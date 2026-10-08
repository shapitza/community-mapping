package com.communitymap.maps.control;

import com.communitymap.maps.entity.CommunityMap;
import com.communitymap.maps.entity.MapVisibility;
import jakarta.inject.Singleton;
import java.time.OffsetDateTime;
import java.util.List;

@Singleton
public class MapService {

    private static final int DEFAULT_ZOOM = 12;

    private final CommunityMapRepository repository;

    public MapService(CommunityMapRepository repository) {
        this.repository = repository;
    }

    public List<CommunityMap> byOrganization(Long organizationId) {
        return repository.findByOrganizationId(organizationId);
    }

    public CommunityMap find(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public CommunityMap create(Long organizationId, CommunityMap map) {
        map.setOrganizationId(organizationId);
        if (map.getVisibility() == null) map.setVisibility(MapVisibility.PRIVATE);
        if (map.getDefaultZoom() == null) map.setDefaultZoom(DEFAULT_ZOOM);
        var now = OffsetDateTime.now();
        map.setCreatedAt(now);
        map.setUpdatedAt(now);
        return repository.save(map);
    }
}
