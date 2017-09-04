package demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long>{
    @Modifying
    @Query("select o from OrderInfo o where o.isPaid = false and o.account = :account")
    List<OrderInfo> findByAccount(@Param("account") String account);

    @Modifying
    @Transactional
    @Query("update OrderInfo o set o.isPaid = true where o.account = :account")
    void updateOrderIsPaid(@Param("account") String account);
}
