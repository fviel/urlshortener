package com.fviel.urlshortener;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import com.fviel.urlshortener.controllers.UrlController;
import com.fviel.urlshortener.entities.Url;
import com.fviel.urlshortener.enums.ShorterAlgorithmEnum;
import com.fviel.urlshortener.interfaces.UrlManager;

class UrlControllerTest {

    @Mock
    private UrlManager urlManager;

    @InjectMocks
    private UrlController urlController;

    public UrlControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shortenUrl_ShouldReturnShortenedUrl() {
        // Arrange
        String fullUrl = "https://example.com";
        //Url mockUrl = new Url("short.ly/12345");
        Url mockUrl = new Url("https://example.com", "short.ly/12345");       

        when(urlManager.addNewUrl(fullUrl, ShorterAlgorithmEnum.MURMUR3 )).thenReturn(mockUrl);

        // Act
        ResponseEntity<String> response = urlController.shortenUrl(fullUrl);  

        // Assert
        assertNotNull(response);
        if(response != null){
            //Set<String> validAnswers = Set.of("200", "200 OK");
            //assertTrue(validAnswers.contains(response.getStatusCode().toString()), "Invalid answer");
            assertEquals(200, response.getStatusCode().value());
            assertEquals(mockUrl.toString(), response.getBody());
            verify(urlManager, times(1)).addNewUrl(fullUrl, ShorterAlgorithmEnum.MURMUR3);
        }
    }

    @Test
    void shortenUrl_ShouldHandleNullUrlManagerResponse() {
        // Arrange
        String fullUrl = "https://example.com";
        when(urlManager.addNewUrl(fullUrl, ShorterAlgorithmEnum.MURMUR3)).thenReturn(null);
    
        // Act
        ResponseEntity<String> response = urlController.shortenUrl(fullUrl);
    
        // Assert
        assertNotNull(response);
        assertEquals(500, response.getStatusCode().value());
        assertEquals("Failed to shorten URL", response.getBody());
    }

    @Test
    void getUrl_ShouldReturnShortenedUrl() {
        // Arrange
        String fullUrl = "https://example.com";
        String shortenedUrl = "short.ly/12345";
        when(urlManager.getShortenUrlByOriginalUrl(fullUrl)).thenReturn(shortenedUrl);

        // Act
        ResponseEntity<String> response = urlController.getUrl(fullUrl);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals(shortenedUrl, response.getBody());
        verify(urlManager, times(1)).getShortenUrlByOriginalUrl(fullUrl);
    }

    @Test
    void getUrl_ShouldReturn404WhenFullUrlIsNull() {
        // Arrange
        String fullUrl = null;

        // Act
        ResponseEntity<String> response = urlController.getUrl(fullUrl);

        // Assert
        assertEquals(404, response.getStatusCode().value());
        assertEquals("Resource not found", response.getBody());
    }

    @Test
    void getUrl_ShouldReturnEmptyResponseIfUrlManagerReturnsNull() {
        // Arrange
        String fullUrl = "https://example.com";
        when(urlManager.getShortenUrlByOriginalUrl(fullUrl)).thenReturn(null);

        // Act
        ResponseEntity<String> response = urlController.getUrl(fullUrl);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertNull(response.getBody());
    }
}
