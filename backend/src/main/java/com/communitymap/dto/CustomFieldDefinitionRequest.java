package com.communitymap.dto;
import com.communitymap.domain.enums.FieldType;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Serdeable
public record CustomFieldDefinitionRequest(@NotBlank String name, @NotBlank String label,
 @NotNull FieldType fieldType, Boolean required, String optionsJson, Integer displayOrder) {}
