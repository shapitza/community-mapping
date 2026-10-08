package com.communitymap.categories.boundary;

import com.communitymap.categories.control.CategoryService;
import com.communitymap.categories.entity.Category;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.validation.Valid;
import java.util.List;

@Controller("/api/maps/{mapId}/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @Get
    public List<Category> all(Long mapId) {
        return service.byMap(mapId);
    }

    @Post
    public HttpResponse<Category> create(Long mapId, @Body @Valid CategoryRequest request) {
        return HttpResponse.created(service.create(mapId, request.toEntity()));
    }
}
