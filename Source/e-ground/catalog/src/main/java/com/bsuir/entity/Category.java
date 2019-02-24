package com.bsuir.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Class of offer category that extends BaseEntity class.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
@Data
@Entity
public class Category extends BaseEntity {
    /**
     * Necessarily field of Category name.
     */
    @Basic(optional = false)
    @NotNull
    private String name;

    /**
     * Field of offers whose category.
     */
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @NotNull
    private List<Offer> offers = new ArrayList<>();

    /**
     * Constructor without params that create object without initialization fields.
     */
    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Category.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("offers=" + offers)
                .toString();
    }
}