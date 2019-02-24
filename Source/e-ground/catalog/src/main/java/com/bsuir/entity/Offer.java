package com.bsuir.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Class of offer that extends BaseEntity class.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
@Data
@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {
    /**
     * Necessarily field of Offer name.
     */
    @Basic(optional = false)
    private String name;

    /**
     * Field of Offer category.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Category category;

    /**
     * Field of Offer price.
     */
    @NotNull
    @Basic(optional = false)
    private double price;

    /**
     * Constructor without params that create object without initialization fields.
     */
    public Offer() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Objects.equals(name, offer.name) &&
                Objects.equals(category, offer.category) &&
                Objects.equals(price, offer.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, category, price);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Offer.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("category=" + category)
                .add("price=" + price)
                .toString();
    }
}
