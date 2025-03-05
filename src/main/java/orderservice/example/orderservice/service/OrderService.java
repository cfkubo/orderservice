package orderservice.example.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import orderservice.example.orderservice.model.Order;
import orderservice.example.orderservice.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Order createOrder(Order order) {
        // return orderRepository.save(order);
        orderRepository.logConnection();
        Order savedOrder = orderRepository.save(order);
        orderRepository.logTableCreation();
        return savedOrder;
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    // public Order updateOrder(Long id, Order orderDetails) {
    //     Order order = orderRepository.findById(id).orElse(null);
    //     if (order != null) {
    //         order.setCustomerName(orderDetails.getCustomerName());
    //         order.setTotalAmount(orderDetails.getTotalAmount());
    //         return orderRepository.save(order);
    //     }
    //     return null;
    // }

    @Transactional
    @Retryable(value = ObjectOptimisticLockingFailureException.class, maxAttempts = 3, backoff = @Backoff(delay = 100))
    public Order updateOrder(Long id, Order orderDetails) {
        Order existingOrder = orderRepository.findById(id).orElse(null);
        if (existingOrder != null) {
            // Update the existing order with orderDetails
            existingOrder.setCustomerName(orderDetails.getCustomerName());
            existingOrder.setTotalAmount(orderDetails.getTotalAmount());
            return orderRepository.save(existingOrder);
        }
        return null;
    }


    public boolean deleteOrder(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            orderRepository.delete(order);
            return true;
        }
        return false;
    }
}