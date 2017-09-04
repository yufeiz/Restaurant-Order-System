package demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by vagrant on 8/23/17.
 */
public interface RestaurantInfoRepository extends JpaRepository<RestaurantInformation, Long> {
    RestaurantInformation findRestaurantInformationById(@Param("id") long id);
    List<RestaurantInformation> findRestaurantInformationByNameContaining(@Param("name") String name);

    @Query("select r.restaurantItems from RestaurantInformation r where r.id = :id")
    List<RestaurantItem> findRestaurantItemsById(@Param("id") long id);
}
