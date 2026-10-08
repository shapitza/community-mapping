package com.communitymap.categories.boundary;

import com.communitymap.categories.entity.Category;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;

@Serdeable
public record CategoryRequest(@NotBlank String name, String description, String color, String icon) {

    Category toEntity() {
        var category = new Category();
        category.setName(name);
        category.setDescription(description);
        category.setColor(color);
        category.setIcon(icon);
        return category;
    }
}
