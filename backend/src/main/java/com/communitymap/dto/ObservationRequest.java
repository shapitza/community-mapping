package com.communitymap.dto;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
@Serdeable
public record ObservationRequest(String title, @NotBlank String description,
 OffsetDateTime observedAt, Long actorUserId) {}
