package com.porunit.notification;

import com.porunit.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository repository;

    public void send(NotificationRequest request){
        repository.save(
                Notification.builder()
                        .toCustomerId(request.toCustomerId())
                        .sender("Porunit")
                        .message(request.message())
                        .toCustomerEmail(request.toCustomerEmail())
                        .sentAt(LocalDateTime.now())
                .build()
        );
    }
}
