package com.porunit.clients.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public record FraudCheckResponse(Boolean isFraudster) {
}
