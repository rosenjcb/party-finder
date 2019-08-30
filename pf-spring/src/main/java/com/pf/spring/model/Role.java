package com.pf.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "roles")
public class Role implements Serializable {

    @Id
    private int id;

    private String roleName;

    @OneToMany(mappedBy = "role")
    private Set<PartyMember> partyMembers;

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

    public Set<PartyMember> getPartyMembers() {
        return partyMembers;
    }

    public void setPartyMembers(Set<PartyMember> partyMembers) {
        this.partyMembers = partyMembers;
    }
}
