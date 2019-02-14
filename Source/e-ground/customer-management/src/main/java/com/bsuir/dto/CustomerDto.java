package com.bsuir.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.UUID;

/**
 * Class of Customer Data Transfer Object. Used to transfer data between application subsystems.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
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
    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")
    private String phoneNumber;

    public CustomerDto() {

    }
}
