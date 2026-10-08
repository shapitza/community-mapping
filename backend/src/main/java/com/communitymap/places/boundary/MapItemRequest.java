package com.communitymap.places.boundary;

import com.communitymap.places.entity.MapItem;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Serdeable
public record MapItemRequest(
        @NotNull Long categoryId,
        Long statusId,
        @NotBlank String title,
        String description,
        @NotNull BigDecimal latitude,
        @NotNull BigDecimal longitude,
        String address,
        Long actorUserId) {

    MapItem toEntity() {
        var item = new MapItem();
        item.setCategoryId(categoryId);
        item.setStatusId(statusId);
        item.setTitle(title);
        item.setDescription(description);
        item.setLatitude(latitude);
        item.setLongitude(longitude);
        item.setAddress(address);
        return item;
    }
}
