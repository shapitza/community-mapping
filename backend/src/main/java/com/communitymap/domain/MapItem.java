package com.communitymap.domain;

import io.micronaut.data.annotation.*;
import io.micronaut.serde.annotation.Serdeable;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Serdeable
@MappedEntity("map_item")
public class MapItem {
    @Id @GeneratedValue private Long id;
    private Long mapId;
    private Long categoryId;
    private Long statusId;
    private String title;
    private String description;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String address;
    private Long createdBy;
    private Long updatedBy;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public Long getMapId(){return mapId;} public void setMapId(Long v){mapId=v;}
    public Long getCategoryId(){return categoryId;} public void setCategoryId(Long v){categoryId=v;}
    public Long getStatusId(){return statusId;} public void setStatusId(Long v){statusId=v;}
    public String getTitle(){return title;} public void setTitle(String v){title=v;}
    public String getDescription(){return description;} public void setDescription(String v){description=v;}
    public BigDecimal getLatitude(){return latitude;} public void setLatitude(BigDecimal v){latitude=v;}
    public BigDecimal getLongitude(){return longitude;} public void setLongitude(BigDecimal v){longitude=v;}
    public String getAddress(){return address;} public void setAddress(String v){address=v;}
    public Long getCreatedBy(){return createdBy;} public void setCreatedBy(Long v){createdBy=v;}
    public Long getUpdatedBy(){return updatedBy;} public void setUpdatedBy(Long v){updatedBy=v;}
    public OffsetDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(OffsetDateTime v){createdAt=v;}
    public OffsetDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(OffsetDateTime v){updatedAt=v;}
}
