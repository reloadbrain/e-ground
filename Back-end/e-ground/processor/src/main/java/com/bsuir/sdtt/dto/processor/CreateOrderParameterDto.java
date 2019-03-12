package com.bsuir.sdtt.dto.processor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class CreateOrderParameterDto {
    private UUID customerId;

    private UUID itemId;

    private int itemCount;
}
