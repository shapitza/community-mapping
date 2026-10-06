package com.communitymap.controller;
import com.communitymap.domain.Observation;
import com.communitymap.dto.ObservationRequest;
import com.communitymap.service.ObservationService;
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
