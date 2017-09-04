package demo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.domain.PaymentInfo;
import demo.domain.RequestInfo;
import demo.domain.ResponseInfo;
import demo.service.ItemsPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Created by vagrant on 9/2/17.
 */
@RestController
@EnableBinding(Source.class)
public class PaymentServiceController {
    @Autowired
    private ItemsPaymentService itemsPaymentService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MessageChannel output;

    @RequestMapping(value = "/checkout/", method = RequestMethod.POST)
    public List<PaymentInfo> getPaymentStatus(@RequestBody RequestInfo requestInfo) throws IOException{
        itemsPaymentService.updateBankInfo(requestInfo);
        List<PaymentInfo> paymentInfos = itemsPaymentService.payItems(requestInfo);
        String payment = objectMapper.writeValueAsString(paymentInfos);
        MessageBuilder messageBuilder = MessageBuilder.withPayload(payment);
        this.output.send(messageBuilder.build());
        return paymentInfos;
    }
}
