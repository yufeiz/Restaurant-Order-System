package demo.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import demo.domain.PaymentInfo;
import demo.domain.RequestInfo;
import demo.domain.ResponseInfo;
import demo.service.ItemsPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by vagrant on 9/1/17.
 */
@Service
@Slf4j
public class ItemsPaymentServiceImpl implements ItemsPaymentService {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${order.account.url}")
    private String orderInfoByAccountUrl;

    @Value("${bank.info.update.url}")
    private String bankInfoUpdateUrl;
    @Autowired
    private ObjectMapper objectMapper;

    private long paymentId = 1;

    @HystrixCommand(fallbackMethod = "processPaymentFallback")
    @Override
    public List<PaymentInfo> payItems(RequestInfo requestInfo) throws IOException {
        String orderInfoStringFormat = restTemplate.getForObject(orderInfoByAccountUrl + requestInfo.getAccount(), String.class);
        log.info(orderInfoStringFormat);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        List<PaymentInfo> paymentInfos = this.objectMapper.readValue(orderInfoStringFormat, new TypeReference<List<PaymentInfo>>(){});
        for (PaymentInfo paymentInfo : paymentInfos) {
            paymentInfo.setCardNum(paymentInfo.getCardNum());
            paymentInfo.setSecureCode(paymentInfo.getSecureCode());
            paymentInfo.setExpireDate(paymentInfo.getExpireDate());
            paymentInfo.setTimestamp(timestamp);
            paymentInfo.setPaymentId(paymentId);
            paymentInfo.setDeliverTime((int)(Math.random() * 9 + 1));
        }
        paymentId++;
        return paymentInfos;
    }
    @Override
    public void updateBankInfo(RequestInfo requestInfo) {
        restTemplate.postForObject(bankInfoUpdateUrl, requestInfo, String.class);
    }
    public void processPaymentFallback(RequestInfo requestInfos) {
        log.error("Hystrix Fallback Method. Unable to update order");
    }
}
