package com.communitymap.places.control;

import com.communitymap.places.entity.MapItem;
import jakarta.inject.Singleton;
import java.time.OffsetDateTime;
import java.util.List;

@Singleton
public class MapItemService {

    private final MapItemRepository repository;

    public MapItemService(MapItemRepository repository) {
        this.repository = repository;
    }

    public List<MapItem> byMap(Long mapId) {
        return repository.findByMapId(mapId);
    }

    public MapItem find(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public MapItem create(Long mapId, MapItem item, Long actorUserId) {
        item.setMapId(mapId);
        item.setCreatedBy(actorUserId);
        item.setUpdatedBy(actorUserId);
        var now = OffsetDateTime.now();
        item.setCreatedAt(now);
        item.setUpdatedAt(now);
        return repository.save(item);
    }
}
