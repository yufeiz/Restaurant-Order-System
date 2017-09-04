package demo.domain;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.sql.Time;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantItem {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String image;

    private String description;
    private double price;

    @ManyToOne
    @JoinColumn(name = "restaurantInformationId")
    @JsonBackReference
    private RestaurantInformation restaurantInformation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public RestaurantInformation getRestaurantInformation() {
        return restaurantInformation;
    }

    public void setRestaurantInformation(RestaurantInformation restaurantInformation) {
        this.restaurantInformation = restaurantInformation;
    }
}
