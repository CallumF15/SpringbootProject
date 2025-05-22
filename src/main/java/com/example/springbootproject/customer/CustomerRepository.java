package com.example.springbootproject.customer;

import org.springframework.data.repository.CrudRepository;



public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Customer findCustomerById(Integer id);
    Customer findCustomerByFirstNameIgnoreCase(String firstName);
    Customer findCustomerByLastNameIgnoreCase(String lastName);
    Customer findCustomerByEmailIgnoreCase(String email);
}