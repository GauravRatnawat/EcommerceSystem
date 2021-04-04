# Spring-Swagger API EcommerceSystem

## Overview
This project provides a EcommerceSystem for demonstrating the basics of enabling Swagger 2.0 definitions on a Spring Boot project with RESTful endpoints. 
The project is based on a Create/Read application for managing `Order` objects with REST endpoints exposed for all the operations that can be performed on the entity being managed. 
The project is a Spring Boot application that is annotated to enable support for Swagger 2.0. 
A `Docket` is defined on the `SwaggerConfig` class to initialize the underlying services that are responsible for generating the Swagger definitions. 
Springfox automatically detects the use of Spring Boot Web MVC and infers from the endpoints defined in the `OrderController` and generates the corresponding API definitions for Swagger. 
New Swagger-specific endpoints are injected into the Spring Boot application to allow for browsing the documentation using Swagger UI as well as for viewing the resulting JSON Swagger Definitions file. 

## Technologies
The following are the key technologies used in the project:
- Spring Boot [http://projects.spring.io/spring-boot/](http://projects.spring.io/spring-boot/)
- Springfox [http://springfox.github.io/springfox/docs/current/](http://springfox.github.io/springfox/docs/current/)
- Jackson(tandard JSON library for Java) [https://github.com/FasterXML/jackson]

## Running the Project
To run the project:

METHOD 1 (from Eclipse IDE)
1. Open the Project in Eclipse IDE
	Eclipse main menu -> File -> Open Projects from File System... -> Choose Project root folder
2. Right click Project Root in the Project Explorer of Eclipse, showing context menu, Run as -> Spring boot App  

METHOD 2 (from command prompt)
1. Install Maven (https://howtodoinjava.com/maven/how-to-install-maven-on-windows/)
2. Open Command Prompt
3. Go to the Root directory of the Project
4. Run the `package` Maven task: `mvn package`
5. Go to the `target` directory
6. Run the generated JAR file: `java -jar <JAR-file>`

> *Note:* that there is no UI for this application; it only exposes REST endpoints

To view the generated Swagger UI documentation go to: [http://localhost:8080/api/swagger-ui.html](http://localhost:8080/api/swagger-ui.html)

To view the JSON Swagger definitions, go to: [http://localhost:8080/api/v2/api-docs](http://localhost:8080/api/v2/api-docs)

