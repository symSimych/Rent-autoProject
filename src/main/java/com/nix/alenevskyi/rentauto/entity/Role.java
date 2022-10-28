package com.nix.alenevskyi.rentauto.entity;

public enum Role {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    private String roleName;
    Role(String roleName) {
        this.roleName = roleName;
    }
}
