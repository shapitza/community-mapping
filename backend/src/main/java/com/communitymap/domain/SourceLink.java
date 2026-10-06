package com.communitymap.domain;

import io.micronaut.data.annotation.*;
import io.micronaut.serde.annotation.Serdeable;

import java.time.OffsetDateTime;
@Serdeable
@MappedEntity("source_link")
public class SourceLink {
    @Id @GeneratedValue private Long id;
    private Long mapItemId;
    private String label;
    private String url;
    private Long createdBy;
    private OffsetDateTime createdAt;
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public Long getMapItemId(){return mapItemId;} public void setMapItemId(Long v){mapItemId=v;}
    public String getLabel(){return label;} public void setLabel(String v){label=v;}
    public String getUrl(){return url;} public void setUrl(String v){url=v;}
    public Long getCreatedBy(){return createdBy;} public void setCreatedBy(Long v){createdBy=v;}
    public OffsetDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(OffsetDateTime v){createdAt=v;}
}
