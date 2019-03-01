package com.bsuir.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Class of order address that extends BaseEntity class.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
@Data
@Entity
@Builder
public class Address extends BaseEntity {
    /**
     * Field of city.
     */
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
    @Min(1)
    private int houseNumber;

    /**
     * Field of order.
     */
    @OneToOne
    private Order order;

    /**
     * Constructor without params that create object without initialization fields.
     */
    public Address() {
    }
}