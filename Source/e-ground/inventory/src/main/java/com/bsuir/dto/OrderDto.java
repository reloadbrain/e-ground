package com.bsuir.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.UUID;

/**
 * Class of Order Data Transfer Object. Used to transfer data between application subsystems.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
@Data
@Builder
public class OrderDto {
    private UUID id;

    @NotNull
    private String customerId;

    @NotNull
    @Pattern(regexp = "^\\d+")
    private String orderNumber;

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
    private int houseNumber;

    public OrderDto() {

    }
}
