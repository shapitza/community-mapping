package com.communitymap.places.boundary;

import com.communitymap.places.control.MapItemService;
import com.communitymap.places.entity.MapItem;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.validation.Valid;
import java.util.List;

@Controller("/api")
public class MapItemController {

    private final MapItemService service;

    public MapItemController(MapItemService service) {
        this.service = service;
    }

    @Get("/maps/{mapId}/items")
    public List<MapItem> all(Long mapId) {
        return service.byMap(mapId);
    }

    @Get("/items/{id}")
    public MapItem one(Long id) {
        return service.find(id);
    }

    @Post("/maps/{mapId}/items")
    public HttpResponse<MapItem> create(Long mapId, @Body @Valid MapItemRequest request) {
        return HttpResponse.created(service.create(mapId, request.toEntity(), request.actorUserId()));
    }
}
