package demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by vagrant on 9/3/17.
 */
@Entity
@Table(name = "order_info")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderInfo {
        @Id
        @GeneratedValue
        private long id;

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

        @ManyToOne
        @JoinColumn(name = "bankInfoAccount")
        @JsonBackReference
        private BankInfo bankInfo;

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getAccount() {
                return account;
        }

        public void setAccount(String account) {
                this.account = account;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getImage() {
                return image;
        }

        public void setImage(String image) {
                this.image = image;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public double getPrice() {
                return price;
        }

        public void setPrice(double price) {
                this.price = price;
        }

        public int getQuantity() {
                return quantity;
        }

        public void setQuantity(int quantity) {
                this.quantity = quantity;
        }

        public String getNote() {
                return note;
        }

        public void setNote(String note) {
                this.note = note;
        }

        public String getTime() {
                return time;
        }

        public void setTime(String time) {
                this.time = time;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public Boolean getIsPaid() {
                return isPaid;
        }

        public void setIsPaid(Boolean paid) {
                isPaid = paid;
        }

        public BankInfo getBankInfo() {
                return bankInfo;
        }

        public void setBankInfo(BankInfo bankInfo) {
                this.bankInfo = bankInfo;
        }
}
