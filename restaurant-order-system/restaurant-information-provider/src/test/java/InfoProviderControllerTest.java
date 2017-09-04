import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import demo.RestaurantInfoProviderApplication;
import demo.domain.RestaurantInfoRepository;
import demo.domain.RestaurantInformation;
import demo.rest.RestaurantInfoProviderController;
import demo.service.RestaurantService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by vagrant on 9/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestaurantInfoProviderApplication.class)
@WebAppConfiguration
public class InfoProviderControllerTest {

    @Autowired
    private RestaurantInfoRepository restaurantInfoRepository;

    @Test
    public void saveRestaurantInfo() {
        String name = "Chengdu Taste";
        this.restaurantInfoRepository.save(new RestaurantInformation(name));
        assertThat(this.restaurantInfoRepository.findRestaurantInformationByNameContaining(name).get(0).equals(name));
    }
}
