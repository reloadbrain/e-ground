package com.bsuir.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.UUID;

@Getter
@Setter
public class AddressDto implements BaseEntityDto {
    @Null
    private UUID id;

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
    private int houseNumber;
}