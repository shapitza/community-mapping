package com.communitymap.organizations.entity;

import io.micronaut.data.annotation.*;
import io.micronaut.serde.annotation.Serdeable;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Serdeable
@MappedEntity("organization")
public class Organization {
    @Id @GeneratedValue private Long id;
    private String name;
    private String description;
    private BigDecimal defaultLatitude;
    private BigDecimal defaultLongitude;
    private Integer defaultZoom;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public Long getId(){return id;} public void setId(Long v){id=v;}
    public String getName(){return name;} public void setName(String v){name=v;}
    public String getDescription(){return description;} public void setDescription(String v){description=v;}
    public BigDecimal getDefaultLatitude(){return defaultLatitude;} public void setDefaultLatitude(BigDecimal v){defaultLatitude=v;}
    public BigDecimal getDefaultLongitude(){return defaultLongitude;} public void setDefaultLongitude(BigDecimal v){defaultLongitude=v;}
    public Integer getDefaultZoom(){return defaultZoom;} public void setDefaultZoom(Integer v){defaultZoom=v;}
    public OffsetDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(OffsetDateTime v){createdAt=v;}
    public OffsetDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(OffsetDateTime v){updatedAt=v;}
}
