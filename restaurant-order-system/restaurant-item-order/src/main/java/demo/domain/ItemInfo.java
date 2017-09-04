package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

/**
 * Created by vagrant on 8/31/17.
 */
@Data
@JsonInclude
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ItemInfo {
    private String account;
    private String name;
    private String image;
    private String description;
    private double price;
    private int quantity;
    private String note;
    private String time;
    private String address;
    private Boolean isPaid;
}
