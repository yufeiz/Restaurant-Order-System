package demo.service;

import demo.domain.BankInfo;
import demo.domain.RestaurantItem;
import demo.domain.RestaurantInformation;

import java.util.List;

/**
 * Created by vagrant on 8/23/17.
 */
public interface RestaurantService {
    List<RestaurantInformation> saveRestaurantInfo(List<RestaurantInformation> resturantInfo);

    void setOrderInfo(String account);

    List<RestaurantInformation> findRestaurantInformationByName(String name);

    List<RestaurantItem> findRestaurantDetailsById(long id);

}
