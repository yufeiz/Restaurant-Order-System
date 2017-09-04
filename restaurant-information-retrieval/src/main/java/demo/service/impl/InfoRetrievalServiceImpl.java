package demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import demo.domain.ItemInfo;
import demo.domain.RestaurantInfo;
import demo.service.InfoRetrievalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * Created by vagrant on 9/2/17.
 */
@Service
@Slf4j
public class InfoRetrievalServiceImpl implements InfoRetrievalService{

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    ObjectMapper objectMapper;


    @Value("${restaurantInfo.retrieval.url}")
    private String restaurantInfoUrl;

    @Value(("${restaurantItemsInfo.retrieval.url}"))
    private String restaurantItemsInfoUrl;

    @Value("${itemInfo.retrieval.url}")
    private String itemInfoUrl;

    @Override
    public ItemInfo itemRetrival(long id) throws IOException {
        ItemInfo itemInfo = restTemplate.getForObject(itemInfoUrl + Long.toString(id), ItemInfo.class);
        return itemInfo;
    }

    @Override
    public List<ItemInfo> restaurantItemsRetrival(long id) throws IOException{
        String restaurantItemsStringFormat = restTemplate.getForObject(restaurantItemsInfoUrl + Long.toString(id), String.class);
        log.info(restaurantItemsStringFormat);
        List<ItemInfo> restaurantDetails = objectMapper.readValue(restaurantItemsStringFormat, List.class);
        return restaurantDetails;
    }

    @Override
    public List<RestaurantInfo> restaurantsRetrival(String name) throws IOException{
        String restaurantsStringFormat = restTemplate.getForObject(restaurantInfoUrl + name, String.class);
        log.info(restaurantsStringFormat);
        List<RestaurantInfo> restaurantInfos = objectMapper.readValue(restaurantsStringFormat, List.class);
        return restaurantInfos;
    }
}