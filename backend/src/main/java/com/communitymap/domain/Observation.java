package com.communitymap.domain;

import io.micronaut.data.annotation.*;
import io.micronaut.serde.annotation.Serdeable;

import java.time.OffsetDateTime;
@Serdeable
@MappedEntity("observation")
public class Observation {
    @Id @GeneratedValue private Long id;
    private Long mapItemId;
    private String title;
    private String description;
    private OffsetDateTime observedAt;
    private Long createdBy;
    private OffsetDateTime createdAt;
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public Long getMapItemId(){return mapItemId;} public void setMapItemId(Long v){mapItemId=v;}
    public String getTitle(){return title;} public void setTitle(String v){title=v;}
    public String getDescription(){return description;} public void setDescription(String v){description=v;}
    public OffsetDateTime getObservedAt(){return observedAt;} public void setObservedAt(OffsetDateTime v){observedAt=v;}
    public Long getCreatedBy(){return createdBy;} public void setCreatedBy(Long v){createdBy=v;}
    public OffsetDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(OffsetDateTime v){createdAt=v;}
}
