# DDD

[![DDD Basic Concept 1](https://raw.githubusercontent.com/GauravRatnawat/EcommerceSystem/main/src/doc/images/DDD1.png "DDD Basic Concept 1")](https://raw.githubusercontent.com/GauravRatnawat/EcommerceSystem/main/src/doc/images/DDD1.png "DDD Basic Concept 1")
[![DDD Concepts 2](https://raw.githubusercontent.com/GauravRatnawat/EcommerceSystem/main/src/doc/images/DDD2.png "DDD Concepts 2")](https://raw.githubusercontent.com/GauravRatnawat/EcommerceSystem/main/src/doc/images/DDD2.png "DDD Concepts 2")

## **Scenario:**
An e-commerce clothing store is looking to re-design its monolithic system into a more modular system following domain driven design. Below are the main processes, flows, and functionalities in the system:
- Customers can view, filter and sort products on the site.
- Customers can order products, paying via card or through Paypal.
- Customers can redeem gift coupons and promotions to purchase products at a discounted price.
- Products should be updated via regular product feeds to update availability, sizes, and discontinuations.
- Customers can view their order history
- Customers can track unfulfilled orders.
- Customers can edit their personal information such as contact details and billing address.
 

We can identify three main areas in our problem domain that can be viewed as sub-domains. These are:
1. The **customer** sub-domain, responsible for handling customer-related information and performing functionality such as updating user details.
2. The **order** sub-domain, responsible for handling order-related functionality such as order histories, tracking, and fulfillment. Promotions and coupons could also be part of this sub-domain and form part of the order domain entity. However, it's also possible to split these into their own sub-domain. Similarly with payments.
3. The **product** sub-domain, responsible for handling functionality such as search, product feed updates. The core domain entity here would, of course, be the product entity.


The following is a high-level component diagram:
 

 [![ECommerce DDD](https://raw.githubusercontent.com/GauravRatnawat/EcommerceSystem/main/src/doc/images/DDD3.png "ECommerce DDD")](https://raw.githubusercontent.com/GauravRatnawat/EcommerceSystem/main/src/doc/images/DDD3.png "ECommerce DDD")
 
Now, let's identify some Domain-driven design elements that will help us design our system, and code it out in later sections of the course. Let's discuss these within the bounded context of each subdomain:

### Product Sub-domain
- The product here is an entity that can be identified by its Id. A product can also act as the domain root of the components within the product module.
- The product can have properties that are entities such as the nearest available store, whilst other properties could be value objects such as the product color.
- Once the feed updater has triggered a product update, a domain event can be emitted that can be picked up by interested components - such as the customer sub-domain to notify users that products they are interested in are available.

### Order Sub-domain
- The order is definitely an entity as it is uniquely identifiable by its Id.
- The sub-domain's components could emit order created/updated/fulfilled domain events that would most likely interest the customer sub-domain.
- The order placement component could make use of an Order Cost Calculation domain service, that order domain objects would call to obtain the order total values. Another possible domain service would be a shipping calculator service.

### Customer Sub-domain
- The customer object here will definitely be an entity, identified by Id.
- It could contain both value types such as the address together with sub-entities.
- Quite a straightforward sub-domain so there seems to be no immediate need for domain services or events.

##### Applicable to all sub-domains:
- Use of repository pattern to persist domain objects.
- Use of factory pattern to create domain objects.

We will going to implement Order Subdomain in this excercise:

[![Order SubDomain](https://raw.githubusercontent.com/GauravRatnawat/EcommerceSystem/main/src/doc/images/DDD4.png "Order SubDomain")](https://raw.githubusercontent.com/GauravRatnawat/EcommerceSystem/main/src/doc/images/DDD4.png "Order SubDomain")


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

