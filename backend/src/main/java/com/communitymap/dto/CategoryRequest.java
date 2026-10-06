package com.communitymap.dto;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
@Serdeable
public record CategoryRequest(@NotBlank String name, String description, String color, String icon) {}
