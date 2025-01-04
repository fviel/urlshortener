# Commands for project 
---

## 1. Configures GIT vars
```
git config --global user.name "Fernando Viel"
git config --global user.email "nandoviel@gmail.com"
```
---
## 2. Configures Ubuntu, Docker, Java
### 2.1. Updates my apt repository
```
sudo apt update
```
### 2.2. Install's docker at my Ubuntu 
```
sudo apt install docker docker-ce
```

### 2.3. Starts docker daemon
```
sudo systemctl status docker
```

### 2.4. Grants permissions for my user to run docker commands without sudo
```
sudo usermod -aG sudo $USER
```

### 2.5. Lists my locally cached docker images
```
docker images
```

### 2.6. Get Redis image
```
docker pull redis:7.4.1-alpine
```
### 2.7. Runs Redis container from the image, just for test. Uses a volume, saving at every 60 secs
```
docker run -d --name redis-container -p 6374:6374 -v redis-data:/data redis:alpine --save 60 1
```
### 2.8. Opens redis-cli to interact directly with Redis
```
docker exec -it redis-container redis-cli
```
### 2.9. Installs OpenJDK 17
```
sudo apt install openjdk-17-jdk
```

### 2.10. Checks my current JDK version
```
javac --version
```

### 2.11. Checks current JRE version
```
java --version
```

### 2.12. Checks current maven version
```
mvn --version
```

### 2.13. Chooses the current JDK
```
sudo update-alternatives --config java
```

### 2.14. Defines $JAVA_HOME 
```
sudo vim /etc/environment
```
#### 2.15. Add following lines
> JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64/
> PATH="/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin:$JAVA_HOME"

```
sudo vim .bashrc 
```
#### 2.16. Add following lines at the end of the file
> export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64/
> export PATH="/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin:$JAVA_HOME"
```
source ~/.bashrc
```

### 2.17. Checks current $JAVA_HOME
```
echo $JAVA_HOME
```
---

## 3. Buils locally the application

### 3.1. Builds the shorty-app
```
clear;mvn clean install -Dspring.profiles.active=dev
```

### 3.2. Runs tests
```
mvn test
```

### 3.3. Runs my Springboot app locally
```
mvn spring-boot:run
```

---
## 4. Docker commands  


###  4.1. Builds the docker image from the Dockerfile from shorty-app project
```
sudo docker build -t shorty-app:0.0.1 .
```

### 4.2. Turn down containers
```
docker compose down
```

### 4.3. Turn up containers
```
docker compose up --build
```
  
### 4.4. Connects containers to a network
```
docker network connect app-network redis
docker network connect app-network shorty-app
```

### 4.5. Show network details
```
docker inspect network app-network
```