package demo.rest;

import demo.domain.*;
import demo.service.RestaurantService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vagrant on 8/23/17.
 */
@RestController
public class RestaurantInfoProviderController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantInfoRepository restaurantInfoRepository;

    @Autowired
    private RestaurantItemRepository restaurantItemRepository;

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @Autowired BankInfoRepository bankInfoRepository;

    @RequestMapping(value = "/orderInfo", method = RequestMethod.POST)
    public List<OrderInfo> perisistOrderInfo(@RequestBody List<OrderInfo> orderInfos) {
        return this.orderInfoRepository.save(orderInfos);
    }

    @RequestMapping(value = "/bankInfo/update/", method = RequestMethod.POST)
    public BankInfo persistBankInfo(@RequestBody BankInfo bankInfo) {
        return this.bankInfoRepository.save(bankInfo);
    }
    @RequestMapping(value = "/orderInfo/isPaid/{account}", method = RequestMethod.GET)
    private void setOrderInfoIsPaid(@PathVariable String account) {
         this.restaurantService.setOrderInfo(account);
    }

    @RequestMapping(value = "/orderInfo/{account}", method = RequestMethod.GET)
    public List<OrderInfo> getOrderInfoByAccount(@PathVariable String account) {
        return this.orderInfoRepository.findByAccount(account);
    }

    @RequestMapping(value = "/restaurantInfo", method = RequestMethod.POST)
    public List<RestaurantInformation> perisistResturantInfo(@RequestBody List<RestaurantInformation> restaurantInformations) {
        return this.restaurantService.saveRestaurantInfo(restaurantInformations);
    }

    @RequestMapping(value = "/restaurantId/items/{id}", method = RequestMethod.GET)
    public List<RestaurantItem> getRestauarantDetailsById (@PathVariable long id) {

        return this.restaurantService.findRestaurantDetailsById(id);
    }

    @RequestMapping(value = "/restaurantName/{name}", method = RequestMethod.GET)
    public List<RestaurantInformation> getRestaurantInfoByName(@PathVariable String name) {
        return this.restaurantService.findRestaurantInformationByName(name);
    }

    @RequestMapping(value = "/restaurantInfo", method = RequestMethod.GET)
    public List<RestaurantInformation> getAll() {
        return this.restaurantInfoRepository.findAll();
    }

    @RequestMapping(value = "/restaurant/item/{id}", method = RequestMethod.GET)
    public RestaurantItem getRestaurantItem(@PathVariable long id) {
        return this.restaurantItemRepository.findById(id);
    }
}
