package com.porunit.customer;

public class CustomerService {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .build();

        //todo: check if email valid
        //todo: check if email not taken
        //todo: check if customer in db
    }
}
