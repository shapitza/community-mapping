package com.communitymap.organizations.boundary;

import com.communitymap.organizations.entity.Organization;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Serdeable
public record OrganizationRequest(
        @NotBlank String name,
        String description,
        BigDecimal defaultLatitude,
        BigDecimal defaultLongitude,
        Integer defaultZoom) {

    Organization toEntity() {
        var organization = new Organization();
        organization.setName(name);
        organization.setDescription(description);
        organization.setDefaultLatitude(defaultLatitude);
        organization.setDefaultLongitude(defaultLongitude);
        organization.setDefaultZoom(defaultZoom);
        return organization;
    }
}
