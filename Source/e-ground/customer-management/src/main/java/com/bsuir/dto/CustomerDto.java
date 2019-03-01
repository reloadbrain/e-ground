package com.bsuir.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.UUID;

/**
 * Class of Customer Data Transfer Object. Used to transfer data between application subsystems.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
@Data
@Builder
public class CustomerDto {
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

    @NotNull
    private String password;

    /**
     * Field of customer number
     */
    @NotNull
    @Pattern(regexp = "^\\+375(29|33|44)\\d{7}$")
    private String phoneNumber;

    public CustomerDto() {

    }
}
