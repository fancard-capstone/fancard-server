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
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ///
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}