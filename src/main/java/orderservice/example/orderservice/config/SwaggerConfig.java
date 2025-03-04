// package orderservice.example.orderservice.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import springfox.documentation.builders.PathSelectors;
// import springfox.documentation.builders.RequestHandlerSelectors;
// import springfox.documentation.spi.DocumentationType;
// import springfox.documentation.spring.web.plugins.Docket;
// import springfox.documentation.swagger2.annotations.EnableSwagger2;

// @Configuration
// @EnableSwagger2
// public class SwaggerConfig {

//     @Bean
//     public Docket api() {
//         return new Docket(DocumentationType.SWAGGER_2)
//                 .select()
//                 .apis(RequestHandlerSelectors.basePackage("orderservice.example.orderservice.controller"))
//                 .paths(PathSelectors.any())
//                 .build();
//     }
// }

// package orderservice.example.orderservice.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// // import springfox.documentation.builders.PathSelectors;
// // import springfox.documentation.builders.RequestHandlerSelectors;
// // import springfox.documentation.spi.DocumentationType;
// // import springfox.documentation.spring.web.plugins.Docket;
// // import springfox.documentation.swagger2.annotations.EnableSwagger2;

// @Configuration
// @EnableSwagger2
// public class SwaggerConfig {

//     @Bean
//     Docket api() {
//         return new Docket(DocumentationType.SWAGGER_2)
//         .select()
//         .apis(RequestHandlerSelectors.basePackage("orderservice.example.orderservice.controller"))
//         .paths(PathSelectors.any())
//         .build();
//     }
// }

package orderservice.example.orderservice.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    GroupedOpenApi api() {
        return GroupedOpenApi.builder()
            .group("v1")
            .pathsToMatch("/api/**")
            .packagesToScan("orderservice.example.orderservice.controller")
            .build();
    }
}