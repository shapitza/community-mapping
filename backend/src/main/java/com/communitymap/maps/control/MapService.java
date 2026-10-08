package com.communitymap.maps.control;
import com.communitymap.maps.entity.CommunityMap;
import com.communitymap.maps.entity.MapVisibility;
import com.communitymap.maps.boundary.MapRequest;
import jakarta.inject.Singleton;
import java.time.OffsetDateTime;
import java.util.List;

@Singleton
public class MapService {
    private final CommunityMapRepository repository;
    public MapService(CommunityMapRepository repository){this.repository=repository;}
    public List<CommunityMap> byOrganization(Long organizationId){return repository.findByOrganizationId(organizationId);}
    public CommunityMap find(Long id){return repository.findById(id).orElseThrow();}
    public CommunityMap create(Long organizationId, MapRequest r){
        CommunityMap m=new CommunityMap(); m.setOrganizationId(organizationId); m.setName(r.name());
        m.setDescription(r.description()); m.setVisibility(r.visibility()==null?MapVisibility.PRIVATE:r.visibility());
        m.setCenterLatitude(r.centerLatitude()); m.setCenterLongitude(r.centerLongitude());
        m.setDefaultZoom(r.defaultZoom()==null?12:r.defaultZoom());
        m.setCreatedAt(OffsetDateTime.now()); m.setUpdatedAt(OffsetDateTime.now());
        return repository.save(m);
    }
}
