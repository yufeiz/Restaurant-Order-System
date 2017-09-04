package demo.service;

import demo.domain.ItemInfo;
import demo.domain.RestaurantInfo;

import java.io.IOException;
import java.util.List;

/**
 * Created by vagrant on 9/2/17.
 */
public interface InfoRetrievalService {
     List<ItemInfo> restaurantItemsRetrival(long id) throws IOException;
     List<RestaurantInfo> restaurantsRetrival(String name) throws IOException;
     ItemInfo itemRetrival(long id) throws IOException;

}
