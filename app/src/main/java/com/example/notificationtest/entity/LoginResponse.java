package com.example.notificationtest.entity;

import java.util.List;

public class LoginResponse {
    private String result;
    private String username;
    private List<String> roles;
    private List<String> roleNameList;
    private double deptId;

    public double getDeptId() {
        return deptId;
    }

    public void setDeptId(double deptId) {
        this.deptId = deptId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List getRoleNameList() {
        return roleNameList;
    }

    public void setRoleNameList(List<String> roleNameList) {
        this.roleNameList = roleNameList;
    }
}
