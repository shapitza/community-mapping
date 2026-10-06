package com.communitymap.controller;
import com.communitymap.domain.CommunityMap;
import com.communitymap.dto.MapRequest;
import com.communitymap.service.MapService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
@Controller("/api")
public class MapController {
 private final MapService service;
 public MapController(MapService s){service=s;}
 @Get("/organizations/{organizationId}/maps") public List<CommunityMap> all(Long organizationId){return service.byOrganization(organizationId);}
 @Get("/maps/{id}") public CommunityMap one(Long id){return service.find(id);}
 @Post("/organizations/{organizationId}/maps") public HttpResponse<CommunityMap> create(Long organizationId,@Body @Valid MapRequest r){return HttpResponse.created(service.create(organizationId,r));}
}
