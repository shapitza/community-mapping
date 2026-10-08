package com.communitymap.categories.entity;

import io.micronaut.data.annotation.*;
import io.micronaut.data.model.DataType;
import io.micronaut.serde.annotation.Serdeable;

import java.time.OffsetDateTime;
@Serdeable
@MappedEntity("custom_field_definition")
public class CustomFieldDefinition {
    @Id @GeneratedValue private Long id;
    private Long categoryId;
    private String name;
    private String label;
    @MappedProperty(type = DataType.STRING) private FieldType fieldType;
    private Boolean required;
    private String optionsJson;
    private Integer displayOrder;
    private OffsetDateTime createdAt;
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public Long getCategoryId(){return categoryId;} public void setCategoryId(Long v){categoryId=v;}
    public String getName(){return name;} public void setName(String v){name=v;}
    public String getLabel(){return label;} public void setLabel(String v){label=v;}
    public FieldType getFieldType(){return fieldType;} public void setFieldType(FieldType v){fieldType=v;}
    public Boolean getRequired(){return required;} public void setRequired(Boolean v){required=v;}
    public String getOptionsJson(){return optionsJson;} public void setOptionsJson(String v){optionsJson=v;}
    public Integer getDisplayOrder(){return displayOrder;} public void setDisplayOrder(Integer v){displayOrder=v;}
    public OffsetDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(OffsetDateTime v){createdAt=v;}
}
