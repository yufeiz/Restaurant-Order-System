package demo.service.impl;

import demo.domain.*;
import demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vagrant on 8/23/17.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {


    @Autowired
    RestaurantInfoRepository restaurantInfoRepository;

    @Autowired
    RestaurantItemRepository restaurantItemRepository;

    @Autowired
    OrderInfoRepository orderInfoRepository;

    @Autowired
    BankInfoRepository bankInfoRepository;

    @Override
    public List<RestaurantItem> findRestaurantDetailsById(long id) {
        return this.restaurantInfoRepository.findRestaurantItemsById(id);
    }

    @Override
    public List<RestaurantInformation> saveRestaurantInfo(List<RestaurantInformation> restaurantInfo) {
        return this.restaurantInfoRepository.save(restaurantInfo);
    }

    @Override
    public void setOrderInfo(String account) {
        this.orderInfoRepository.updateOrderIsPaid(account);
    }

    @Override
    public List<RestaurantInformation> findRestaurantInformationByName(String name) {
        name = name.toUpperCase();
        return this.restaurantInfoRepository.findRestaurantInformationByNameContaining(name);
    }
}
