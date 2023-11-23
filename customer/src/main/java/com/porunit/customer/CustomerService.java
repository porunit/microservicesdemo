package com.porunit.customer;

import com.porunit.clients.fraud.FraudCheckResponse;
import com.porunit.clients.fraud.FraudClient;
import com.porunit.clients.notification.NotificationClient;
import com.porunit.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .build();
        log.info(String.valueOf(customer));
        //todo: check if email valid
        //todo: check if email not taken
        //todo: check if customer in db
        customerRepository.saveAndFlush(customer);

       FraudCheckResponse response = fraudClient.isFraudster(customer.getId());
       if(response.isFraudster()){
           throw new IllegalStateException("Fraudster");
       }

       //todo: make it async. queue
       notificationClient.sendNotification(
              new NotificationRequest(
                      customer.getId(),
                      customer.getEmail(),
                      String.format("Hi %s, welcome to porunit.com", customer.getFirstname())
              )
       );
    }
}
