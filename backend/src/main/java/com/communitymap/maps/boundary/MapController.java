package com.communitymap.maps.boundary;

import com.communitymap.maps.control.MapService;
import com.communitymap.maps.entity.CommunityMap;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.validation.Valid;
import java.util.List;

@Controller("/api")
public class MapController {

    private final MapService service;

    public MapController(MapService service) {
        this.service = service;
    }

    @Get("/organizations/{organizationId}/maps")
    public List<CommunityMap> all(Long organizationId) {
        return service.byOrganization(organizationId);
    }

    @Get("/maps/{id}")
    public CommunityMap one(Long id) {
        return service.find(id);
    }

    @Post("/organizations/{organizationId}/maps")
    public HttpResponse<CommunityMap> create(Long organizationId, @Body @Valid MapRequest request) {
        return HttpResponse.created(service.create(organizationId, request.toEntity()));
    }
}
