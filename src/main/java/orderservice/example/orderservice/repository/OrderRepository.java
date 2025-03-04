package orderservice.example.orderservice.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import orderservice.example.orderservice.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    default void logConnection() {
        Logger logger = LoggerFactory.getLogger(OrderRepository.class);
        logger.info("Connected to PostgreSQL database successfully.");
    }

    default void logTableCreation() {
        Logger logger = LoggerFactory.getLogger(OrderRepository.class);
        logger.info("Order table created successfully.");
    }
}
