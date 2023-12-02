# Assignment-7-Microservice-Communications

This repository contains a simple example of microservices architecture with Spring Boot.
 
## Project Structure
 
- `product-service`: Microservice responsible for managing product data.
- `customer-service`: Microservice interacting with the product-service to display products.
 
## Setup and Run
 
1. Clone the Repository:
git clone https://github.com/premkumar1526/Springboot-Assignment-7.git
   cd Assignment-7-Microservice-Communications
2. Run product-service:
cd product-service
./mvnw spring-boot:run
Product Service will be available at http://localhost:8081
3. Run customer-service:
cd ../customer-service
./mvnw spring-boot:runCustomer Service will be available at http://localhost:8082
4. Access Endpoints:
Product Service Endpoints:
http://localhost:8081/api/products/
Customer Service Endpoints:
http://localhost:8082/api/customers/

## Database Configuration
Modify application.properties in each service to configure.
