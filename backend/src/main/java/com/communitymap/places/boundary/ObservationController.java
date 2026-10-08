package com.communitymap.places.boundary;

import com.communitymap.places.control.ObservationService;
import com.communitymap.places.entity.Observation;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.validation.Valid;
import java.util.List;

@Controller("/api/items/{itemId}/observations")
public class ObservationController {

    private final ObservationService service;

    public ObservationController(ObservationService service) {
        this.service = service;
    }

    @Get
    public List<Observation> all(Long itemId) {
        return service.byItem(itemId);
    }

    @Post
    public HttpResponse<Observation> create(Long itemId, @Body @Valid ObservationRequest request) {
        return HttpResponse.created(service.create(itemId, request.toEntity(), request.actorUserId()));
    }
}
