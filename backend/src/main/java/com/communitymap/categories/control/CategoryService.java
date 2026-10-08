package com.communitymap.categories.control;

import com.communitymap.categories.entity.Category;
import jakarta.inject.Singleton;
import java.time.OffsetDateTime;
import java.util.List;

@Singleton
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> byMap(Long mapId) {
        return repository.findByMapId(mapId);
    }

    public Category create(Long mapId, Category category) {
        category.setMapId(mapId);
        category.setActive(true);
        var now = OffsetDateTime.now();
        category.setCreatedAt(now);
        category.setUpdatedAt(now);
        return repository.save(category);
    }
}
