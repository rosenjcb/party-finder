/*
package com.pf.spring.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity(name = "open_roles")
//@JsonSerialize(using = OpenRoleSerializer.class)
public class OpenRole implements Serializable {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name =  "party_id", nullable = false, insertable = false, updatable = false)
    private Party party;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false, insertable = false, updatable = false)
    private Role role;

    private boolean isOpen;

    public OpenRole() {

    }

    public OpenRole(Party party, Role role) {
        this.id = UUID.randomUUID();
        this.party = party;
        this.role = role;
        this.isOpen = true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("party = " + party.getName()).append("\n");
        sb.append("role = " + role.getRoleName()).append("\n");
        return sb.toString();
    }

    */
/*public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*//*


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


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
*/
