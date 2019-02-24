package com.bsuir.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

/**
 * Class of Order Data Transfer Object. Used to transfer data between application subsystems.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
@Getter
@Setter
public class OrderDto implements BaseEntityDto {
    private UUID id;

    @NotNull
    @Pattern(regexp = "^\\d+")
    private String orderNumber;

    @NotNull
    private String name;

    /**
     * Field of order status.
     */
    @NotNull
    @Pattern(regexp = "DONE|IN_PROGRESS")
    private String status;

    /**
     * Field of order delivery address.
     */
    @NotNull
    private AddressDto deliveryAddress;

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

    public OrderDto() {

    }
}
