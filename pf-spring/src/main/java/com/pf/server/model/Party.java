package com.pf.server.model;


import com.pf.server.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity(name = "parties")
public class Party implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy = "party", cascade = CascadeType.ALL, orphanRemoval=true)
    private Set<OpenRole> openRoles;

    public Party() {

    }

    public Party(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<OpenRole> getOpenRoles() {
        return openRoles;
    }

    public void setOpenRoles(Set<OpenRole> openRoles) {
        this.openRoles = openRoles;
    }

    public void addOpenRole(OpenRole openRole) {
        this.openRoles.add(openRole);
    }
}
