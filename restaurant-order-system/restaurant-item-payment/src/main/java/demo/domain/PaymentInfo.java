package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by vagrant on 9/1/17.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class PaymentInfo {
    private String account;
    private String cardNum;
    private String ExpireDate;
    private String secureCode;
    private long paymentId;
    private double deliverTime;
    private Timestamp timestamp;
}
