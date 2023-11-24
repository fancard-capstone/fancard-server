package com.FANCardPlus.model;

import javax.persistence.*;

@Entity
@Table(name = "permission", schema="dbo")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Long permissionId;

    public Long getPermissionId() {
        return permissionId;
    }

    public void getPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    ///

    @Column(name = "name", columnDefinition = "TEXT")
    private String permissionName;

    public String getPermissionName() {
        return permissionName;
    }

    public void setName(String permissionName) {
        this.permissionName = permissionName;
    }

    ///
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String permissionDescription;

    public String getPermissionDescription() {
        return permissionDescription;
    }

    public void setPermissionDescription(String permissionDescription) {
        this.permissionDescription = permissionDescription;
    }
}