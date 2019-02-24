package com.bsuir.entity;

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
@Table(name = "orders")
public class Order extends BaseEntity {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.totalPrice, totalPrice) == 0 &&
                orderItemCount == order.orderItemCount &&
                Objects.equals(orderNumber, order.orderNumber) &&
                Objects.equals(name, order.name) &&
                Objects.equals(status, order.status) &&
                Objects.equals(deliveryAddress, order.deliveryAddress) &&
                Objects.equals(email, order.email) &&
                Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orderNumber, name, status, deliveryAddress, email, totalPrice, orderItemCount, date);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]")
                .add("orderNumber='" + orderNumber + "'")
                .add("name='" + name + "'")
                .add("status='" + status + "'")
                .add("deliveryAddress=" + deliveryAddress)
                .add("email='" + email + "'")
                .add("totalPrice=" + totalPrice)
                .add("orderItemCount=" + orderItemCount)
                .add("date=" + date)
                .toString();
    }
}