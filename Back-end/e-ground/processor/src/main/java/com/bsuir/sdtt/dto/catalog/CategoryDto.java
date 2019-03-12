package com.bsuir.sdtt.dto.catalog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class CategoryDto {
    private UUID id;

    /**
     * Field of Category name
     */
    @NotNull
    private String name;

    public CategoryDto() {
    }
}
