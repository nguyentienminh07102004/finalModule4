package com.ptitB22DCCN539.finalModule4.Repository;

import com.ptitB22DCCN539.finalModule4.Model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    @Query(value = "SELECT o FROM OrderEntity o WHERE (?1 IS NULL OR o.dateCreated >= ?1) AND (?2 IS NULL OR o.dateCreated <= ?2)")
    public List<OrderEntity> find(Date dateStart, Date dateEnd);
}
