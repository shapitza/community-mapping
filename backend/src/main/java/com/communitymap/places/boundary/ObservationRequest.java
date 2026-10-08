package com.communitymap.places.boundary;

import com.communitymap.places.entity.Observation;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import java.time.OffsetDateTime;

@Serdeable
public record ObservationRequest(
        String title,
        @NotBlank String description,
        OffsetDateTime observedAt,
        Long actorUserId) {

    Observation toEntity() {
        var observation = new Observation();
        observation.setTitle(title);
        observation.setDescription(description);
        observation.setObservedAt(observedAt);
        return observation;
    }
}
