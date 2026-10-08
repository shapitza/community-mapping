package com.communitymap.organizations.boundary;
import com.communitymap.organizations.entity.Organization;
import com.communitymap.organizations.control.OrganizationService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
@Controller("/api/organizations")
public class OrganizationController {
 private final OrganizationService service;
 public OrganizationController(OrganizationService s){service=s;}
 @Get public List<Organization> all(){return service.findAll();}
 @Get("/{id}") public Organization one(Long id){return service.find(id);}
 @Post public HttpResponse<Organization> create(@Body @Valid OrganizationRequest r){return HttpResponse.created(service.create(r));}
}
