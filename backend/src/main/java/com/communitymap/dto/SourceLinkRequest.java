package com.communitymap.dto;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
@Serdeable
public record SourceLinkRequest(String label, @NotBlank String url, Long actorUserId) {}
