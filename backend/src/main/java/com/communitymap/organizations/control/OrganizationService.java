package com.communitymap.organizations.control;
import com.communitymap.organizations.entity.Organization;
import com.communitymap.organizations.boundary.OrganizationRequest;
import jakarta.inject.Singleton;
import java.time.OffsetDateTime;
import java.util.List;

@Singleton
public class OrganizationService {
    private final OrganizationRepository repository;
    public OrganizationService(OrganizationRepository repository){this.repository=repository;}
    public List<Organization> findAll(){return (List<Organization>) repository.findAll();}
    public Organization find(Long id){return repository.findById(id).orElseThrow();}
    public Organization create(OrganizationRequest r){
        Organization o=new Organization();
        o.setName(r.name()); o.setDescription(r.description());
        o.setDefaultLatitude(r.defaultLatitude()); o.setDefaultLongitude(r.defaultLongitude());
        o.setDefaultZoom(r.defaultZoom()==null?12:r.defaultZoom());
        o.setCreatedAt(OffsetDateTime.now()); o.setUpdatedAt(OffsetDateTime.now());
        return repository.save(o);
    }
}
