package com.example.springbootproject.items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByNameContainingIgnoreCase(String name);


    //Price related
    List<Item> findByPriceLessThan(BigDecimal price);
    List<Item> findByPriceGreaterThan(BigDecimal price);
}
