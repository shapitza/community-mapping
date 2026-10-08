package com.communitymap.places.entity;

import io.micronaut.data.annotation.*;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@MappedEntity("status_definition")
public class StatusDefinition {
    @Id @GeneratedValue private Long id;
    private Long mapId;
    private String name;
    private Integer displayOrder;
    private Boolean terminal;
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public Long getMapId(){return mapId;} public void setMapId(Long v){mapId=v;}
    public String getName(){return name;} public void setName(String v){name=v;}
    public Integer getDisplayOrder(){return displayOrder;} public void setDisplayOrder(Integer v){displayOrder=v;}
    public Boolean getTerminal(){return terminal;} public void setTerminal(Boolean v){terminal=v;}
}
