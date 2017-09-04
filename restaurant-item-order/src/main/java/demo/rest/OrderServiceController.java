package demo.rest;

import demo.domain.ItemInfo;
import demo.domain.RequestInfo;
import demo.service.ItemOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.stream.annotation.EnableBinding;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by vagrant on 9/1/17.
 */
@RestController
public class OrderServiceController {


    @Autowired
    private ItemOrderService itemOrderService;


    @RequestMapping(path = "/items/order/", method = RequestMethod.POST)
    public List<ItemInfo> items(@RequestBody List<RequestInfo> requestInfos) {
        List<ItemInfo> itemInfos = this.itemOrderService.saveOrder(requestInfos);
        return itemInfos;
    }

}
