package com.bsuir.dto.catalog;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Builder
public class OfferDto {
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
}
