package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
public class RestaurantInfoProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestaurantInfoProviderApplication.class, args);
    }
}
