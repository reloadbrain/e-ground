package com.bsuir.dto.processor;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Getter
@Setter
public class CreateOrderParameterDto {
    @NotNull
    private String city;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Pattern(regexp = "^\\d+")
    private String houseNumber;

    @NotNull
    private String street;

    /**
     * Field of Offer name.
     */
    @NotNull
    private String name;

    /**
     * Field of Offer category.
     */
    @NotNull
    private String category;

    /**
     * Field of Offer price.
     */
    @NotNull
    @Min(0)
    private double price;

    /**
     * Field of order item count.
     */
    @NotNull
    @Min(0)
    private int orderItemCount;
}
