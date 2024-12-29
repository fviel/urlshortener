FROM tomcat:10.1.34-jdk17-temurin

# Set environment variables
ENV CATALINA_HOME=/usr/local/tomcat
ENV PATH=$CATALINA_HOME/bin:$PATH

# Remove default ROOT application to avoid conflicts
RUN rm -rf $CATALINA_HOME/webapps/ROOT

# Copy the WAR file to the webapps directory in Tomcat
COPY target/urlshortener-0.0.1-SNAPSHOT.war $CATALINA_HOME/webapps/ROOT.war

# Expose the Tomcat port (default is 8080)
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]