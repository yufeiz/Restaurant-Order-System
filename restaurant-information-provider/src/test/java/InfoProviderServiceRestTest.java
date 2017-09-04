import com.google.gson.Gson;
import demo.RestaurantInfoProviderApplication;
import demo.domain.BankInfo;
import demo.domain.OrderInfo;
import demo.domain.OrderInfoRepository;
import demo.domain.RestaurantInformation;
import org.hibernate.criterion.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by vagrant on 9/4/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestaurantInfoProviderApplication.class)
@WebIntegrationTest(randomPort = true)
public class InfoProviderServiceRestTest {

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    private String orderInfoString;

    OrderInfo orderInfo;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        orderInfo = new OrderInfo();
        orderInfo.setId(1);
        orderInfo.setName("Chengdu Taste");
        orderInfo.setAccount("yufeiz");
        orderInfo.setIsPaid(false);
        List<OrderInfo> orderInfos = new ArrayList<OrderInfo>();
        orderInfos.add(orderInfo);
        this.orderInfoRepository.save(orderInfos);

    }

    @Test
    public void testGetRestaurantInfoUrl() throws Exception {
        this.mockMvc.perform(get("/orderInfo/isPaid/")
                    .content("yufeiz"))
                    .andExpect(status().isOk());
    }
}
