package com.communitymap.places.control;

import com.communitymap.places.entity.Observation;
import jakarta.inject.Singleton;
import java.time.OffsetDateTime;
import java.util.List;

@Singleton
public class ObservationService {

    private final ObservationRepository repository;

    public ObservationService(ObservationRepository repository) {
        this.repository = repository;
    }

    public List<Observation> byItem(Long itemId) {
        return repository.findByMapItemId(itemId);
    }

    public Observation create(Long itemId, Observation observation, Long actorUserId) {
        var now = OffsetDateTime.now();
        observation.setMapItemId(itemId);
        if (observation.getObservedAt() == null) observation.setObservedAt(now);
        observation.setCreatedBy(actorUserId);
        observation.setCreatedAt(now);
        return repository.save(observation);
    }
}
