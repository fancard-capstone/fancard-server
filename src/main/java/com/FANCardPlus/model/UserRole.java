package com.FANCardPlus.model;

import javax.persistence.*;

@Entity
@Table(name = "user_role", schema="dbo")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private Long userRoleId;

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    ///

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; 

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
