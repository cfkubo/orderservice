package orderservice.example.orderservice.config;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;

@Configuration
public class LoggingConfig {

    @jakarta.annotation.PostConstruct
    public void init() {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.getLogger("org.springdoc").setLevel(Level.DEBUG);
    }
}