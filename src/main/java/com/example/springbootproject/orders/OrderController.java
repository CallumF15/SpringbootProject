package com.example.springbootproject.orders;

import com.example.springbootproject.customer.Customer;
import com.example.springbootproject.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrdersRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/add")
    public String addOrder(@RequestParam String title) {

        LocalDateTime orderDate = LocalDateTime.now(); // current timestamp

        Orders order = new Orders();
        order.setOrderTitle(title);
        order.setOrderDate(orderDate);

        // fetch customer from repository
        Integer customerId = 1; //test purposes (delete after)
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer == null) {
            return "Customer not found";
        }

        order.setCustomer(customer);
        orderRepository.save(order);

        return "Added new order to repo!";
    }

    @GetMapping("/list")
    public Iterable<Orders> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/byCustomer/{customerId}")
    public List<Orders> getOrdersByCustomer(@PathVariable Integer customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @GetMapping("/by-customer-name/{name}")
    public List<Orders> getOrdersByCustomerName(@PathVariable String name) {
        return orderRepository.findOrdersByCustomerName(name);
    }

    @GetMapping("/by-customer-id/{id}")
    public List<Orders> getOrdersByCustomerId(@PathVariable Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        return orderRepository.findByCustomer(customer);
    }
}
