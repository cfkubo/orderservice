package orderservice.example.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>Welcome to Order Service!</h1>");
        sb.append("<h2>Available Endpoints:</h2>");
        sb.append("<ul>");

        // Add the static endpoints as clickable links
        sb.append("<li><a href=\"http://localhost:8080/api/orders\" target=\"_blank\">POST /api/orders</a></li>");
        sb.append("<li><a href=\"http://localhost:9090/actuator\" target=\"_blank\">GET /actuator</a></li>");
        sb.append("<li><a href=\"http://localhost:9090/actuator/swagger-ui/index.html#/\" target=\"_blank\">Swagger UI</a></li>");
        sb.append("<li><a href=\"http://localhost:9090/actuator/openapi/v1\" target=\"_blank\">GET /actuator/openapi/v1</a></li>");
        sb.append("<li><a href=\"http://localhost:9090/actuator/openapi/x-actuator\" target=\"_blank\">GET /actuator/openapi/x-actuator</a></li>");
        sb.append("<li><a href=\"http://localhost:9090/actuator/swagger-ui/index.html?urls.primaryName=x-actuator\" target=\"_blank\">Swagger UI (x-actuator)</a></li>");

        sb.append("</ul>");
        return sb.toString();
    }
}