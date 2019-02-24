package com.bsuir.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.UUID;

/**
 * Class of Category Data Transfer Object. Used to transfer data between application subsystems.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
@Getter
@Setter
public class CategoryDto implements BaseEntityDto {
    @Null
    private UUID id;

    /**
     * Field of Category name
     */
    @NotNull
    private String name;

    public CategoryDto() {

    }

    public CategoryDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
