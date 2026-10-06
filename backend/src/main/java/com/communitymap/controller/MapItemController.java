package com.communitymap.controller;
import com.communitymap.domain.MapItem;
import com.communitymap.dto.MapItemRequest;
import com.communitymap.service.MapItemService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
@Controller("/api")
public class MapItemController {
 private final MapItemService service;
 public MapItemController(MapItemService s){service=s;}
 @Get("/maps/{mapId}/items") public List<MapItem> all(Long mapId){return service.byMap(mapId);}
 @Get("/items/{id}") public MapItem one(Long id){return service.find(id);}
 @Post("/maps/{mapId}/items") public HttpResponse<MapItem> create(Long mapId,@Body @Valid MapItemRequest r){return HttpResponse.created(service.create(mapId,r));}
}
