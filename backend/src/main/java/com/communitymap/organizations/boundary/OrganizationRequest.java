package com.communitymap.organizations.boundary;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
@Serdeable
public record OrganizationRequest(@NotBlank String name, String description,
 BigDecimal defaultLatitude, BigDecimal defaultLongitude, Integer defaultZoom) {}
