package com.communitymap.domain;

import com.communitymap.domain.enums.MapVisibility;
import io.micronaut.data.annotation.*;
import io.micronaut.data.model.DataType;
import io.micronaut.serde.annotation.Serdeable;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Serdeable
@MappedEntity("community_map")
public class CommunityMap {
    @Id @GeneratedValue private Long id;
    private Long organizationId;
    private String name;
    private String description;
    @MappedProperty(type = DataType.STRING) private MapVisibility visibility;
    private BigDecimal centerLatitude;
    private BigDecimal centerLongitude;
    private Integer defaultZoom;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public Long getOrganizationId(){return organizationId;} public void setOrganizationId(Long v){organizationId=v;}
    public String getName(){return name;} public void setName(String v){name=v;}
    public String getDescription(){return description;} public void setDescription(String v){description=v;}
    public MapVisibility getVisibility(){return visibility;} public void setVisibility(MapVisibility v){visibility=v;}
    public BigDecimal getCenterLatitude(){return centerLatitude;} public void setCenterLatitude(BigDecimal v){centerLatitude=v;}
    public BigDecimal getCenterLongitude(){return centerLongitude;} public void setCenterLongitude(BigDecimal v){centerLongitude=v;}
    public Integer getDefaultZoom(){return defaultZoom;} public void setDefaultZoom(Integer v){defaultZoom=v;}
    public OffsetDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(OffsetDateTime v){createdAt=v;}
    public OffsetDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(OffsetDateTime v){updatedAt=v;}
}
