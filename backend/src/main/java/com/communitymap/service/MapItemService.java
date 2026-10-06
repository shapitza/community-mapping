package com.communitymap.service;
import com.communitymap.domain.MapItem;
import com.communitymap.dto.MapItemRequest;
import com.communitymap.repository.MapItemRepository;
import jakarta.inject.Singleton;
import java.time.OffsetDateTime;
import java.util.List;
@Singleton
public class MapItemService {
 private final MapItemRepository repository;
 public MapItemService(MapItemRepository r){repository=r;}
 public List<MapItem> byMap(Long mapId){return repository.findByMapId(mapId);}
 public MapItem find(Long id){return repository.findById(id).orElseThrow();}
 public MapItem create(Long mapId, MapItemRequest r){
  MapItem i=new MapItem(); i.setMapId(mapId); i.setCategoryId(r.categoryId()); i.setStatusId(r.statusId());
  i.setTitle(r.title()); i.setDescription(r.description()); i.setLatitude(r.latitude()); i.setLongitude(r.longitude());
  i.setAddress(r.address()); i.setCreatedBy(r.actorUserId()); i.setUpdatedBy(r.actorUserId());
  i.setCreatedAt(OffsetDateTime.now()); i.setUpdatedAt(OffsetDateTime.now()); return repository.save(i);
 }
}
