package com.communitymap.domain;

import io.micronaut.data.annotation.*;
import io.micronaut.serde.annotation.Serdeable;

import java.time.OffsetDateTime;
@Serdeable
@MappedEntity("app_user")
public class AppUser {
    @Id @GeneratedValue private Long id;
    private String email;
    private String displayName;
    private Boolean active;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
    public String getDisplayName(){return displayName;} public void setDisplayName(String v){displayName=v;}
    public Boolean getActive(){return active;} public void setActive(Boolean v){active=v;}
    public OffsetDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(OffsetDateTime v){createdAt=v;}
    public OffsetDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(OffsetDateTime v){updatedAt=v;}
}
