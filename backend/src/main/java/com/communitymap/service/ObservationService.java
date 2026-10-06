package com.communitymap.service;
import com.communitymap.domain.Observation;
import com.communitymap.dto.ObservationRequest;
import com.communitymap.repository.ObservationRepository;
import jakarta.inject.Singleton;
import java.time.OffsetDateTime;
import java.util.List;
@Singleton
public class ObservationService {
 private final ObservationRepository repository;
 public ObservationService(ObservationRepository r){repository=r;}
 public List<Observation> byItem(Long itemId){return repository.findByMapItemId(itemId);}
 public Observation create(Long itemId, ObservationRequest r){
  Observation o=new Observation(); o.setMapItemId(itemId); o.setTitle(r.title()); o.setDescription(r.description());
  o.setObservedAt(r.observedAt()==null?OffsetDateTime.now():r.observedAt()); o.setCreatedBy(r.actorUserId());
  o.setCreatedAt(OffsetDateTime.now()); return repository.save(o);
 }
}
