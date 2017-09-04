package hystrixdashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vagrant on 9/3/17.
 */
@Controller
public class HystrixDashboardController {
    @RequestMapping(value = "/")
    public String home() {
        return "forward:/hystrix";
    }
}
