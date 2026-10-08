package com.communitymap.organizations.control;

import com.communitymap.organizations.entity.Organization;
import jakarta.inject.Singleton;
import java.time.OffsetDateTime;
import java.util.List;

@Singleton
public class OrganizationService {

    private static final int DEFAULT_ZOOM = 12;

    private final OrganizationRepository repository;

    public OrganizationService(OrganizationRepository repository) {
        this.repository = repository;
    }

    public List<Organization> findAll() {
        return repository.findAll();
    }

    public Organization find(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Organization create(Organization organization) {
        if (organization.getDefaultZoom() == null) organization.setDefaultZoom(DEFAULT_ZOOM);
        var now = OffsetDateTime.now();
        organization.setCreatedAt(now);
        organization.setUpdatedAt(now);
        return repository.save(organization);
    }
}
