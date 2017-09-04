package demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by vagrant on 8/31/17.
 */
public interface RestaurantItemRepository extends JpaRepository<RestaurantItem, Long> {
    List<RestaurantItem> findAll();
    RestaurantItem findById(@Param("id") long id);
}
