package com.example.tms_app.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="user_roles")
public class UserRole implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID roleId;

    @Column(name="role_name")
    private String roleName;

    @Version
    @Column(name="user_role_version")
    private Integer userRoleVersion;

    public UserRole() {
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getUserRoleVersion() {
        return userRoleVersion;
    }

    public void setUserRoleVersion(Integer userRoleVersion) {
        this.userRoleVersion = userRoleVersion;
    }
}
