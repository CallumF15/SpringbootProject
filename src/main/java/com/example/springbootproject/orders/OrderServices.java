package com.example.springbootproject.orders;

import org.springframework.stereotype.Service;

@Service
public class OrderServices {

    public void AddOrder() {
        Orders order = new Orders();
        //order.setOrderTitle(request.getTitle());
        // set customer, status, date, etc.
        //OrdersRepository.sa(order);
    }
}
