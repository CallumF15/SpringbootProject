package com.example.springbootproject.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/add")
    public String addCustomer(@RequestParam String first, @RequestParam String last) {
        Customer customer = new Customer();
        customer.setFirstName(first);
        customer.setLastName(last);
        customerRepository.save(customer);
        return "Added new customer to repo!";
    }

    @GetMapping("/list")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/find/id/{id}")
    public Customer findCustomerById(@PathVariable Integer id) {
        return customerRepository.findCustomerById(id);
    }

    @GetMapping("/find/name/{firstName}")
    public Customer findByFirstName(@PathVariable String firstName) {
        return customerRepository.findCustomerByFirstNameIgnoreCase(firstName);
    }

    @GetMapping("/find/lastName/{lastName}")
    public Customer findByLastName(@PathVariable String lastName) {
        return customerRepository.findCustomerByLastNameIgnoreCase(lastName);
    }

    @GetMapping("/find/email/{email}")
    public Customer findByEmail(@PathVariable String email) {
        return customerRepository.findCustomerByEmailIgnoreCase(email);
    }

}

