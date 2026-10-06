package com.communitymap.dto;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
@Serdeable
public record MapItemRequest(@NotNull Long categoryId, Long statusId, @NotBlank String title,
 String description, @NotNull BigDecimal latitude, @NotNull BigDecimal longitude, String address, Long actorUserId) {}
