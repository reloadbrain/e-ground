package com.bsuir.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Class of customer that extends BaseEntity class.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
@Data
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
    /**
     * Field of customer name.
     */
    @Basic(optional = false)
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
    @Email
    @NotNull
    private String email;

    /**
     * Field of customer age.
     */
    @Min(1)
    @NotNull
    private int age;

    /**
     * Field of customer number
     */
    @NotNull
    @Column(unique = true)
    private String phoneNumber;

    /**
     * Constructor without params that create object without initialization fields.
     */
    public Customer() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name)
                && Objects.equals(surname, customer.surname)
                && Objects.equals(age, customer.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, surname, age);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Customer.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("surname='" + surname + "'")
                .add("email='" + email + "'")
                .add("age=" + age)
                .toString();
    }
}
