package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * Created by vagrant on 9/3/17.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class PaymentInfo {
    private long paymentId;
    private String account;
    private String name;
    private String cardNum;
    private double deliverTime;
    private String ExpireDate;
    private double price;
    private int quantity;
    private int secureCode;
    private Timestamp timestamp;
}
