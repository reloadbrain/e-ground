package com.bsuir.dto.processor;

import com.bsuir.dto.BaseEntityDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class PayParameterDto implements BaseEntityDto {
    @NotNull
    @Email
    private String email;

    @NotNull
    @Pattern(regexp = "^\\d+")
    private String orderNumber;

    public PayParameterDto() {

    }
}
