package com.communitymap.dto;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
@Serdeable
public record StatusRequest(@NotBlank String name, Integer displayOrder, Boolean terminal) {}
