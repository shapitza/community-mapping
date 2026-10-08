package com.communitymap.places.entity;

import io.micronaut.data.annotation.*;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@MappedEntity("custom_field_value")
public class CustomFieldValue {
    @Id @GeneratedValue private Long id;
    private Long mapItemId;
    private Long fieldDefinitionId;
    private String value;
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public Long getMapItemId(){return mapItemId;} public void setMapItemId(Long v){mapItemId=v;}
    public Long getFieldDefinitionId(){return fieldDefinitionId;} public void setFieldDefinitionId(Long v){fieldDefinitionId=v;}
    public String getValue(){return value;} public void setValue(String v){value=v;}
}
