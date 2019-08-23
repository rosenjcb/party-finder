package com.pf.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pf.server.serializer.OpenRoleSerializer;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "open_roles")
@JsonSerialize(using = OpenRoleSerializer.class)
public class OpenRole implements Serializable {

    @EmbeddedId
    //@JsonIgnore
    private OpenRoleId id;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name =  "party_id", nullable = false, insertable = false, updatable = false)
    //@JsonIgnore
    private Party party;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false, insertable = false, updatable = false)
    private Role role;

    private int quantity;

    public OpenRole() {

    }


    public OpenRole(Party party, Role role, int quantity) {
        this.id = new OpenRoleId(party, role);
        this.party = party;
        this.role = role;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("party = " + party.getName()).append("\n");
        sb.append("role = " + role.getRoleName()).append("\n");
        sb.append("quantity = " + quantity);
        return sb.toString();
    }

    /*public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Role getRole() {
        return role;
    }

    public void setRoleId(Role role) {
        this.role = role;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OpenRoleId getId() {
        return id;
    }

    public void setId(OpenRoleId id) {
        this.id = id;
    }
}
