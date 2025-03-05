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

        // Add sample curl code
        sb.append("<h2>Sample cURL Commands:</h2>");
        sb.append("<pre><code>");
        sb.append("curl -X POST \"http://localhost:8080/api/orders\" \\\n");
        sb.append("-H \"Content-Type: application/json\" \\\n");
        sb.append("-d '{\n");
        sb.append("\"orderId\": 2,\n");
        sb.append("\"customerName\": \"Sample Order\",\n");
        sb.append("\"totalAmount\": 11111111\n");
        sb.append("}'\n");
        sb.append("\n");
        sb.append("<br>\n");
        sb.append("{\n");
        sb.append("\"id\":2,\n");
        sb.append("\"customerName\":\"Sample Order\",\n");
        sb.append("\"totalAmount\":1.1111111E7\n");
        sb.append("}\n");
        sb.append("\n");
        sb.append("<br>\n");
        sb.append("curl -X POST \"http://localhost:8080/api/orders\" \\\n");
        sb.append("-H \"Content-Type: application/json\" \\\n");
        sb.append("-d '{\n");
        sb.append("\"orderId\": 1,\n");
        sb.append("\"orderName\": \"Sample Order\",\n");
        sb.append("\"quantity\": 5,\n");
        sb.append("\"price\": 19.99\n");
        sb.append("}'");
        sb.append("</code></pre>");

        return sb.toString();
    }
}