// // 

// package orderservice.example.orderservice.controller;

// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.media.Content;
// import io.swagger.v3.oas.annotations.media.Schema;
// import io.swagger.v3.oas.annotations.responses.ApiResponse;
// import io.swagger.v3.oas.annotations.responses.ApiResponses;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import orderservice.example.orderservice.model.Order;
// import orderservice.example.orderservice.service.OrderService;


// @RestController
// @RequestMapping("/api/orders")
// @Tag(name = "Order Management System", description = "Operations pertaining to order in Orderservice")
// public class OrderController {

//     @Autowired
//     private OrderService orderService;

//     @PostMapping
//     @Operation(summary = "Create a new order")
//     @ApiResponses(value = {
//             @ApiResponse(responseCode = "200", description = "Order created successfully",
//                     content = @Content(mediaType = "application/json",
//                             schema = @Schema(implementation = Order.class))),
//             @ApiResponse(responseCode = "400", description = "Invalid input")
//     })
//     public ResponseEntity<Order> createOrder(@RequestBody Order order) {
//         Order createdOrder = orderService.createOrder(order);
//         return ResponseEntity.ok(createdOrder);
//     }

//     @GetMapping("/{id}")
//     @Operation(summary = "Retrieve an order by ID")
//     @ApiResponses(value = {
//             @ApiResponse(responseCode = "200", description = "Order found",
//                     content = @Content(mediaType = "application/json",
//                             schema = @Schema(implementation = Order.class))),
//             @ApiResponse(responseCode = "404", description = "Order not found")
//     })
//     public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
//         Order order = orderService.getOrderById(id);
//         if (order != null) {
//             return ResponseEntity.ok(order);
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     @PutMapping("/{id}")
//     @Operation(summary = "Update an existing order")
//     @ApiResponses(value = {
//             @ApiResponse(responseCode = "200", description = "Order updated successfully",
//                     content = @Content(mediaType = "application/json",
//                             schema = @Schema(implementation = Order.class))),
//             @ApiResponse(responseCode = "404", description = "Order not found")
//     })
//     public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
//         Order updatedOrder = orderService.updateOrder(id, orderDetails);
//         if (updatedOrder != null) {
//             return ResponseEntity.ok(updatedOrder);
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     @DeleteMapping("/{id}")
//     @Operation(summary = "Delete an order")
//     @ApiResponses(value = {
//             @ApiResponse(responseCode = "204", description = "Order deleted successfully"),
//             @ApiResponse(responseCode = "404", description = "Order not found")
//     })
//     public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
//         boolean isDeleted = orderService.deleteOrder(id);
//         if (isDeleted) {
//             return ResponseEntity.noContent().build();
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }
// }

package orderservice.example.orderservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import orderservice.example.orderservice.model.Order;
import orderservice.example.orderservice.service.OrderService;

@RestController
@CrossOrigin(origins = "*") // Be more specific in production!
@RequestMapping("/api/orders")
@Tag(name = "Order Management System", description = "Operations pertaining to order in Orderservice")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @Operation(summary = "Create a new order", description = "Creates a new order in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order created successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Order.class),
                            examples = @ExampleObject(value = "{\"id\": 1, \"customerName\": \"John Doe\", \"totalAmount\": 100.00}"))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retrieve an order by ID", description = "Retrieves an order by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Order.class),
                            examples = @ExampleObject(value = "{\"id\": 1, \"customerName\": \"John Doe\", \"totalAmount\": 100.00}"))),
            @ApiResponse(responseCode = "404", description = "Order not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing order", description = "Updates an existing order by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order updated successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Order.class),
                            examples = @ExampleObject(value = "{\"id\": 1, \"customerName\": \"Jane Doe\", \"totalAmount\": 150.00}"))),
            @ApiResponse(responseCode = "404", description = "Order not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        Order updatedOrder = orderService.updateOrder(id, orderDetails);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an order", description = "Deletes an order by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Order deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Order not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        boolean isDeleted = orderService.deleteOrder(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}