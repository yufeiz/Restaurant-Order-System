package demo.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.domain.PaymentInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * Created by vagrant on 9/3/17.
 */
@Slf4j
@Service
@EnableBinding(Sink.class)
public class PaymentProcessorService {
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SimpMessagingTemplate template;

    @Value("${payment.isPaid}")
    private String paymentIsPaid;

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void processPayment(String input) throws IOException {
        List<PaymentInfo> paymentInfos = objectMapper.readValue(input, new TypeReference<List<PaymentInfo>>(){});
        String paymentInfo = restTemplate.getForObject(paymentIsPaid + paymentInfos.get(0).getAccount(), String.class);
        log.info(paymentInfo);
        this.template.convertAndSend("/topic/locations", paymentInfo);
    }

}
