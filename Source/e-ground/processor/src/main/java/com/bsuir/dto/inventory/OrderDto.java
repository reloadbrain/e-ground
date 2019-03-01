package com.bsuir.dto.inventory;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Data
@Builder
public class OrderDto {
    private UUID id;

    @NotNull
    private UUID customerId;

    @NotNull
    private String name;

    /**
     * Field of customer email.
     */
    @NotNull
    @Email
    private String email;

    /**
     * Field of order total price;
     */
    @NotNull
    @Min(0)
    private double totalPrice;

    /**
     * Field of order item count.
     */
    @NotNull
    @Min(0)
    private int orderItemCount;

    /**
     * Field of date.
     */
    @NotNull
    private String date;

    @NotNull
    private String city;

    /**
     * Field of street.
     */
    @NotNull
    private String street;

    /**
     * Field of house number.
     */
    @NotNull
    @Pattern(regexp = "^\\d+")
    private String houseNumber;

    @NotNull
    private String category;

    public OrderDto() {

    }
}
