package com.example.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CustomerQuery implements GraphQLQueryResolver {
    @Autowired
    private CustomerService customerService;

    public List<Customer> getCustomers(final int count){
        return customerService.getAllCustomers(count);
    }

    public Optional<Customer> getCustomer(final int customerNumber){
        return customerService.getCustomer(customerNumber);
    }
}
