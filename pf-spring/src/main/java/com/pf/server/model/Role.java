package com.pf.server.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "roles")
public class Role implements Serializable {

    @Id
    private int id;

    private String roleName;

    @OneToMany(mappedBy = "role")
    private Set<OpenRole> openRoles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<OpenRole> getOpenRoles() {
        return openRoles;
    }

    public void setOpenRoles(Set<OpenRole> openRoles) {
        this.openRoles = openRoles;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
