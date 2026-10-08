package com.communitymap.categories.entity;

import io.micronaut.data.annotation.*;
import io.micronaut.serde.annotation.Serdeable;

import java.time.OffsetDateTime;
@Serdeable
@MappedEntity("category")
public class Category {
    @Id @GeneratedValue private Long id;
    private Long mapId;
    private String name;
    private String description;
    private String color;
    private String icon;
    private Boolean active;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public Long getMapId(){return mapId;} public void setMapId(Long v){mapId=v;}
    public String getName(){return name;} public void setName(String v){name=v;}
    public String getDescription(){return description;} public void setDescription(String v){description=v;}
    public String getColor(){return color;} public void setColor(String v){color=v;}
    public String getIcon(){return icon;} public void setIcon(String v){icon=v;}
    public Boolean getActive(){return active;} public void setActive(Boolean v){active=v;}
    public OffsetDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(OffsetDateTime v){createdAt=v;}
    public OffsetDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(OffsetDateTime v){updatedAt=v;}
}
