package com.communitymap.categories.boundary;
import com.communitymap.categories.entity.Category;
import com.communitymap.categories.control.CategoryService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
@Controller("/api/maps/{mapId}/categories")
public class CategoryController {
 private final CategoryService service;
 public CategoryController(CategoryService s){service=s;}
 @Get public List<Category> all(Long mapId){return service.byMap(mapId);}
 @Post public HttpResponse<Category> create(Long mapId,@Body @Valid CategoryRequest r){return HttpResponse.created(service.create(mapId,r));}
}
