package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by vagrant on 9/3/17.
 */
@Entity
@Table(name = "BankInfo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankInfo {
    @Id
    private String account;

    private String cardNum;
    private String expireDate;
    private String secureCode;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bankInfoAccount")
    @JsonManagedReference
    private Set<OrderInfo> orderInfos;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getSecureCode() {
        return secureCode;
    }

    public void setSecureCode(String secureCode) {
        this.secureCode = secureCode;
    }

    public Set<OrderInfo> getOrderInfos() {
        return orderInfos;
    }

    public void setOrderInfos(Set<OrderInfo> orderInfos) {
        this.orderInfos = orderInfos;
    }
}
