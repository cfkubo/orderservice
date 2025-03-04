package orderservice.example.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import orderservice.example.orderservice.model.Order;
import orderservice.example.orderservice.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            order.setCustomerName(orderDetails.getCustomerName());
            order.setTotalAmount(orderDetails.getTotalAmount());
            return orderRepository.save(order);
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