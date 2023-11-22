package com.porunit.customer;

public record CustomerRegistrationRequest(
        String firstname,
        String lastname,
        String email
) {}
