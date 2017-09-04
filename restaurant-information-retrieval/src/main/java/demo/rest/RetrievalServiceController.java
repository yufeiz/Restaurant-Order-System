package demo.rest;

import demo.domain.ItemInfo;
import demo.domain.RestaurantInfo;
import demo.service.InfoRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Created by vagrant on 9/2/17.
 */
@RestController
public class RetrievalServiceController {
    @Autowired
    InfoRetrievalService infoRetrievalService;

    @RequestMapping(value = "/restaurantName/{name}", method = RequestMethod.GET)
    public List<RestaurantInfo> getRestaurantsInfo(@PathVariable String name) throws IOException{
        return this.infoRetrievalService.restaurantsRetrival(name);
    }

    @RequestMapping(value = "/restaurantId/items/{id}", method = RequestMethod.GET)
    public List<ItemInfo> getItemsInfo(@PathVariable long id) throws IOException {
        return this.infoRetrievalService.restaurantItemsRetrival(id);
    }

    @RequestMapping(value = "/restaurant/item/{id}", method = RequestMethod.GET)
    public ItemInfo getItemInfo(@PathVariable long id) throws IOException {
        return this.infoRetrievalService.itemRetrival(id);
    }
}
