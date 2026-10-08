package com.communitymap.maps.boundary;
import com.communitymap.maps.entity.MapVisibility;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
@Serdeable
public record MapRequest(@NotBlank String name, String description, MapVisibility visibility,
 BigDecimal centerLatitude, BigDecimal centerLongitude, Integer defaultZoom) {}
