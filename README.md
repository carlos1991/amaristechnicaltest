## Author
Carlos Luis Muñoz Acedo

## Requirements
- Java 11
- Maven
- Docker [optional]

Additionally, the base project uses lombok, so you have to install it. You can use the following guide https://www.baeldung.com/lombok-ide

## Build and test 
- Build jar: 
`mvn clean install`
- Build docker image [optional] (make sure the Docker daemon is running and accessible):  
`mvn spring-boot:build-image -Dspring-boot.build-image.imageName=technical-test`

## RUN
- Using maven:  
`mvn spring-boot:run`
- Using docker [optional]:  
`docker run -p 8080:8080 -t technical-test`

## Swagger
Once the application has started, swagger is available at: http://localhost:8080/swagger-ui.html