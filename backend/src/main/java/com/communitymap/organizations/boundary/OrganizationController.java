package com.communitymap.organizations.boundary;

import com.communitymap.organizations.control.OrganizationService;
import com.communitymap.organizations.entity.Organization;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.validation.Valid;
import java.util.List;

@Controller("/api/organizations")
public class OrganizationController {

    private final OrganizationService service;

    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @Get
    public List<Organization> all() {
        return service.findAll();
    }

    @Get("/{id}")
    public Organization one(Long id) {
        return service.find(id);
    }

    @Post
    public HttpResponse<Organization> create(@Body @Valid OrganizationRequest request) {
        return HttpResponse.created(service.create(request.toEntity()));
    }
}
