package com.example.springbootproject.orders;

import com.example.springbootproject.customer.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {

    List<Orders> findByCustomerId(Integer customerId);

    @Query("SELECT o FROM Orders o WHERE LOWER(o.customer.firstName) = LOWER(:name)")
    List<Orders> findOrdersByCustomerName(@Param("name") String name);

    // Or simpler: Find orders by customer
    List<Orders> findByCustomer(Customer customer);


}
