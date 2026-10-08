package com.communitymap.places.boundary;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
@Serdeable
public record StatusRequest(@NotBlank String name, Integer displayOrder, Boolean terminal) {}
