package com.pf.spring.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "roles")
public class Role implements Serializable {

    @Id
    private int id;

    private String roleName;

    @OneToMany(mappedBy = "role")
    private Set<Position> positions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }
}
