package com.communitymap.activity.entity;

import io.micronaut.data.annotation.*;
import io.micronaut.data.model.DataType;
import io.micronaut.serde.annotation.Serdeable;

import java.time.OffsetDateTime;
@Serdeable
@MappedEntity("activity_log")
public class ActivityLog {
    @Id @GeneratedValue private Long id;
    private Long organizationId;
    private Long mapId;
    private Long mapItemId;
    private Long actorUserId;
    @MappedProperty(type = DataType.STRING) private ActivityType activityType;
    private String entityType;
    private Long entityId;
    private String summary;
    private String detailsJson;
    private OffsetDateTime createdAt;
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public Long getOrganizationId(){return organizationId;} public void setOrganizationId(Long v){organizationId=v;}
    public Long getMapId(){return mapId;} public void setMapId(Long v){mapId=v;}
    public Long getMapItemId(){return mapItemId;} public void setMapItemId(Long v){mapItemId=v;}
    public Long getActorUserId(){return actorUserId;} public void setActorUserId(Long v){actorUserId=v;}
    public ActivityType getActivityType(){return activityType;} public void setActivityType(ActivityType v){activityType=v;}
    public String getEntityType(){return entityType;} public void setEntityType(String v){entityType=v;}
    public Long getEntityId(){return entityId;} public void setEntityId(Long v){entityId=v;}
    public String getSummary(){return summary;} public void setSummary(String v){summary=v;}
    public String getDetailsJson(){return detailsJson;} public void setDetailsJson(String v){detailsJson=v;}
    public OffsetDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(OffsetDateTime v){createdAt=v;}
}
