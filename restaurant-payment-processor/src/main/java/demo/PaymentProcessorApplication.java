package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by vagrant on 9/3/17.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentProcessorApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentProcessorApplication.class,args);
    }

}
