package com.bsuir.dto.processor;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class OperationParameterDto {
    @NotNull
    private UUID id;
}
