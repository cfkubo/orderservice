package orderservice.example.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import orderservice.example.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}