package com.porunit.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudCheckService {
    private final FraudCheckHistoryRepository repository;

    public boolean isFraudulentCustomer(Integer customerId) {
        repository.save(FraudCheckHistory.builder()
                        .isFraudster(false)
                        .id(customerId)
                        .createdAt(LocalDateTime.now())
                        .build());
        return false;
    }

}
