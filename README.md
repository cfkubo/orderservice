
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
http://localhost:8080/
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