package com.bsuir.dto.customer;

import com.bsuir.dto.BaseEntityDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.UUID;

@Getter
@Setter
public class CustomerDto implements BaseEntityDto {
    private UUID id;

    /**
     * Field of customer name.
     */
    @NotNull
    private String name;

    /**
     * Field of customer surname.
     */
    @NotNull
    private String surname;

    /**
     * Field of customer email.
     */
    @NotNull
    @Email
    private String email;

    /**
     * Field of customer age.
     */
    @NotNull
    @Min(1)
    private int age;

    /**
     * Field of customer number
     */
    @NotNull

    private String phoneNumber;

    public CustomerDto() {

    }
}
