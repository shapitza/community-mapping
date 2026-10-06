package com.communitymap.domain;

import com.communitymap.domain.enums.UserRole;
import io.micronaut.data.annotation.*;
import io.micronaut.data.model.DataType;
import io.micronaut.serde.annotation.Serdeable;

import java.time.OffsetDateTime;
@Serdeable
@MappedEntity("organization_member")
public class OrganizationMember {
    @Id @GeneratedValue private Long id;
    private Long organizationId;
    private Long userId;
    @MappedProperty(type = DataType.STRING) private UserRole role;
    private OffsetDateTime createdAt;
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public Long getOrganizationId(){return organizationId;} public void setOrganizationId(Long v){organizationId=v;}
    public Long getUserId(){return userId;} public void setUserId(Long v){userId=v;}
    public UserRole getRole(){return role;} public void setRole(UserRole v){role=v;}
    public OffsetDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(OffsetDateTime v){createdAt=v;}
}
