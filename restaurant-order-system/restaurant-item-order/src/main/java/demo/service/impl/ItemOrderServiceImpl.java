package demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import demo.domain.ItemInfo;
import demo.domain.RequestInfo;
import demo.service.ItemOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.misc.Request;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by vagrant on 8/31/17.
 */
@Slf4j
@Service
public class ItemOrderServiceImpl implements ItemOrderService {


    private RestTemplate restTemplate = new RestTemplate();

    @Value("${items.retrieval.url}")
    private String itemsUrl;

    @Value("${order.repository.url}")
    private String orderRepositoryUrl;

    @Autowired
    private ObjectMapper objectMapper;


    @HystrixCommand(fallbackMethod = "processOrderFallback")
    @Override
    public ArrayList<ItemInfo> saveOrder(List<RequestInfo> requestInfos) {
        ArrayList<ItemInfo> itemInfos = new ArrayList<ItemInfo>();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        for(RequestInfo requestInfo: requestInfos) {
            ItemInfo itemInfo = this.restTemplate.getForObject(itemsUrl + requestInfo.getItemId(), ItemInfo.class);
            itemInfo.setAddress(requestInfo.getAddress());
            itemInfo.setNote(requestInfo.getNote());
            itemInfo.setQuantity(requestInfo.getQuantity());
            itemInfo.setAccount(requestInfo.getAccount());
            itemInfo.setTime(dateFormat.format(date));
            itemInfo.setIsPaid(false);
            itemInfos.add(itemInfo);
        }
        return restTemplate.postForObject(orderRepositoryUrl, itemInfos, ArrayList.class);
    }

    public void processOrderFallback(List<RequestInfo> requestInfos) {
        log.error("Hystrix Fallback Method. Unable to update order");
    }
}
