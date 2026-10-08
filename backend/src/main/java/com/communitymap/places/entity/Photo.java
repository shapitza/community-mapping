package com.communitymap.places.entity;

import io.micronaut.data.annotation.*;
import io.micronaut.serde.annotation.Serdeable;

import java.time.OffsetDateTime;
@Serdeable
@MappedEntity("photo")
public class Photo {
    @Id @GeneratedValue private Long id;
    private Long mapItemId;
    private Long observationId;
    private String storageKey;
    private String fileName;
    private String contentType;
    private Long uploadedBy;
    private OffsetDateTime createdAt;
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public Long getMapItemId(){return mapItemId;} public void setMapItemId(Long v){mapItemId=v;}
    public Long getObservationId(){return observationId;} public void setObservationId(Long v){observationId=v;}
    public String getStorageKey(){return storageKey;} public void setStorageKey(String v){storageKey=v;}
    public String getFileName(){return fileName;} public void setFileName(String v){fileName=v;}
    public String getContentType(){return contentType;} public void setContentType(String v){contentType=v;}
    public Long getUploadedBy(){return uploadedBy;} public void setUploadedBy(Long v){uploadedBy=v;}
    public OffsetDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(OffsetDateTime v){createdAt=v;}
}
