package com.communitymap.dto;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;
@Serdeable
public record CustomFieldValueRequest(@NotNull Long fieldDefinitionId, String value) {}
