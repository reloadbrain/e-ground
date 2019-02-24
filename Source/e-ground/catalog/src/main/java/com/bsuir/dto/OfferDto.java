package com.bsuir.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.UUID;

/**
 * Class of Offer Data Transfer Object. Used to transfer data between application subsystems.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
@Getter
@Setter
public class OfferDto implements BaseEntityDto {
    @Null
    private UUID id;

    /**
     * Field of Offer name.
     */
    @NotNull
    private String name;

    /**
     * Field of Offer category.
     */
    @NotNull
    private String category;

    /**
     * Field of Offer price.
     */
    @NotNull
    @Min(0)
    private double price;

    public OfferDto() {

    }

    public OfferDto(UUID id, String name, String category, Integer price, List<String> tags) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
}