package com.communitymap.places.boundary;
import com.communitymap.places.entity.Observation;
import com.communitymap.places.control.ObservationService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
@Controller("/api/items/{itemId}/observations")
public class ObservationController {
 private final ObservationService service;
 public ObservationController(ObservationService s){service=s;}
 @Get public List<Observation> all(Long itemId){return service.byItem(itemId);}
 @Post public HttpResponse<Observation> create(Long itemId,@Body @Valid ObservationRequest r){return HttpResponse.created(service.create(itemId,r));}
}
