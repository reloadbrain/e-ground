package com.bsuir.dto.inventory;

import com.bsuir.dto.BaseEntityDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.UUID;

@Getter
@Setter
public class OrderDto implements BaseEntityDto {
    private UUID id;

    @NotNull
    @Pattern(regexp = "^\\d+")
    private String orderNumber;

    /**
     * Field of order status.
     */
    @NotNull
    @Pattern(regexp = "DONE|IN_PROGRESS")
    private String status;

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
