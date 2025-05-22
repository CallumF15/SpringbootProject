package com.example.springbootproject.orders;

import com.example.springbootproject.customer.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "orders")
public class Orders {

    enum OrderStatus {
        Pending,
        IN_PROGRESS,
        Delivered
    }

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String orderTitle;
    private String orderDescription;
    private OrderStatus orderStatus;

    private LocalDateTime orderDate;

    //getters && Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderTitle() {
        return orderTitle;
    }
    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderDescription() {
        return orderDescription;
    }
    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
