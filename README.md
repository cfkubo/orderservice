# Order Service

The **Order Service** is a Spring Boot-based microservice designed to manage order-related operations. This service provides several endpoints to handle POST requests for creating orders, as well as PUT requests for updating specific orders. The service interacts with a PostgreSQL database and uses RabbitMQ for messaging.

### Project Structure

```
orderservice/
├── pom.xml
└── src
    └── main
        ├── java
        │   └── orderservice
        │       └── example
        │           └── orderservice
        │               ├── OrderserviceApplication.java
        │               ├── controller
        │               │   └── OrderController.java
        │               ├── model
        │               │   └── Order.java
        │               ├── repository
        │               │   └── OrderRepository.java
        │               └── service
        │                   └── OrderService.java
        └── resources
            ├── application.properties
            └── data.sql (optional, for initializing the database)
```

## Key Features
- RESTful API endpoints for order management.
- Integration with a PostgreSQL database using JPA/Hibernate.
- Messaging capabilities through RabbitMQ.
- Actuator for monitoring and managing the application.

## Configuration

The `application.properties` file located at `src/main/resources/application.properties` contains all necessary configurations:

```properties
spring.application.name=orderservice

# PostgreSQL database configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=admin
spring.datasource.password=password
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.hbm2ddl.log_format=standard
spring.jpa.generate-ddl=true

# RabbitMQ configuration
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```

## Building and Running the Application

### Prerequisites
- JDK 21 or higher.
- Maven installed on your system.
- PostgreSQL running on `localhost:5432`.
- RabbitMQ running on `localhost:5672`.

### Steps to Build and Run

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd orderservice
   ```

2. **Build the Project**
   ```bash
   mvn clean install
   ```

3. **Run the Application**
   - You can run the application using Maven:
     ```bash
     mvn spring-boot:run
     ```
   - Alternatively, you can use your IDE to run the `OrderServiceApplication` class.

## Interacting with the Order Service

### Creating an Order

You can create a new order by sending a POST request to `/api/orders`. Here is an example using cURL:

```bash
curl -X POST "http://localhost:8080/api/orders" \
-H "Content-Type: application/json" \
-d '{
  "orderId": 2,
  "customerName": "Sample Order",
  "totalAmount": 11111111
}'
```

### Updating an Order

You can update an existing order by sending a PUT request to `/api/orders/{id}`. Here is an example using cURL:

```bash
curl -X 'PUT' \
'http://localhost:8080/api/orders/11' \
-H 'accept: application/json' \
-H 'Content-Type: application/json' \
-d '{
  "customerName": "string",
  "totalAmount": 0.1
}'
```

### Additional Sample Commands

Here are a few more sample cURL commands to interact with the Order Service:

```bash
curl -X POST "http://localhost:8080/api/orders" \
-H "Content-Type: application/json" \
-d '{
  "customerName": "khanna",
  "totalAmount": 5555
}'

curl -X 'POST' \
'http://127.0.0.1:8080/api/orders' \
-H 'accept: application/json' \
-H 'Content-Type: application/json' \
-d '{
  "customerName": "string",
  "totalAmount": 0.1
}'
```

## Monitoring and Management

The Order Service includes Spring Boot Actuator endpoints, which can be accessed via:

- `http://localhost:8080/actuator` - General actuator information.
- `http://localhost:8080/actuator/swagger-ui/index.html#/` - Swagger UI for API documentation.
- `http://localhost:8080/actuator/openapi/v1` - OpenAPI v1 specification.

## Contributing

If you wish to contribute to this project, please follow the standard GitHub workflow:
1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Push to the branch.
5. Open a pull request.

## License

This project is licensed under the [MIT License](LICENSE).


```
curl -X POST "http://localhost:8080/api/orders" \
     -H "Content-Type: application/json" \
     -d '{
           "orderId": 2,
           "customerName": "Sample Order",
           "totalAmount": 11111111
         }'
```
```
{"id":2,"customerName":"Sample Order","totalAmount":1.1111111E7}
```
```
curl -X POST "http://localhost:8080/api/orders" \
     -H "Content-Type: application/json" \
     -d '{
           "orderId": 1,
           "orderName": "Sample Order",
           "quantity": 5,
           "price": 19.99
         }'
```

```
curl -X POST "http://localhost:8080/api/orders" \
     -H "Content-Type: application/json" \
     -d '{
           "customerName": "khanna",
           "totalAmount": 5555
         }'
```

```
curl -X 'POST' \
  'http://127.0.0.1:8080/api/orders' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "customerName": "string",
  "totalAmount": 0.1
}'
```

```
curl -X 'PUT' \
  'http://127.0.0.1:8080/api/orders/11' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "customerName": "string",
  "totalAmount": 0.1
}'
```

```
http://localhost:9090/actuator
```

```
http://localhost:9090/actuator/swagger-ui/index.html#/
```

```
http://localhost:9090/actuator/openapi/v1
```

```
http://localhost:9090/actuator/openapi/x-actuator
```

```
http://localhost:9090/actuator/swagger-ui/index.html?urls.primaryName=x-actuator
```
