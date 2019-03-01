package com.bsuir.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Class of order that extends BaseEntity class.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
@Data
@Entity
@Builder
@Table(name = "orders")
public class Order extends BaseEntity {
    @NotNull
    private String customerId;

    @NotNull
    private String name;

    /**
     * Field of order delivery address.
     */
    @OneToOne(cascade = CascadeType.ALL)
    private Address deliveryAddress;

    /**
     * Field of customer email.
     */
    @Email
    @NotNull
    private String email;

    /**
     * Field of order total price;
     */
    @Min(0)
    @NotNull
    private double totalPrice;

    /**
     * Field of order item count.
     */
    @Min(0)
    @NotNull
    private int orderItemCount;

    /**
     * Field of date.
     */
    @NotNull
    private LocalDateTime date;

    /**
     * Constructor without params that create object without initialization fields.
     */
    public Order() {
    }
}