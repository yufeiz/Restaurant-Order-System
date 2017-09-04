package demo.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "restaurant_information")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class RestaurantInformation {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    private String image;
    private String description;

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

    public Set<RestaurantItem> getRestaurantItems() {
        return restaurantItems;
    }

    public void setRestaurantItems(Set<RestaurantItem> restaurantItems) {
        this.restaurantItems = restaurantItems;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurantInformationId")
    @JsonManagedReference
    private Set<RestaurantItem> restaurantItems;

    public RestaurantInformation(String name) {
        this.name = name;
    }
}
