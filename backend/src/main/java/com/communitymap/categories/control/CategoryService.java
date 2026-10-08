package com.communitymap.categories.control;
import com.communitymap.categories.entity.Category;
import com.communitymap.categories.boundary.CategoryRequest;
import jakarta.inject.Singleton;
import java.time.OffsetDateTime;
import java.util.List;
@Singleton
public class CategoryService {
 private final CategoryRepository repository;
 public CategoryService(CategoryRepository r){repository=r;}
 public List<Category> byMap(Long mapId){return repository.findByMapId(mapId);}
 public Category create(Long mapId, CategoryRequest r){
  Category c=new Category(); c.setMapId(mapId); c.setName(r.name()); c.setDescription(r.description());
  c.setColor(r.color()); c.setIcon(r.icon()); c.setActive(true);
  c.setCreatedAt(OffsetDateTime.now()); c.setUpdatedAt(OffsetDateTime.now()); return repository.save(c);
 }
}
