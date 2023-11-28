package com.FANCardPlus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "role_permission", schema="dbo")
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_permission_ID")
    private Long rolePermissionId;

    public Long getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(Long rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    ///

    @ManyToOne
    @JoinColumn(name = "permission_id", nullable = false)
    private Permission permission; 

    public Permission getPermission() {
        return permission;
    }

    public void setFaqCategory(Permission permission) {
        this.permission = permission;
    }

    ///

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role; 

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
