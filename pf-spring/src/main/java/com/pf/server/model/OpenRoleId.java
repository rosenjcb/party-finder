package com.pf.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class OpenRoleId implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "party_id", nullable = false, insertable = false, updatable = false)
    private Party party;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false, insertable = false, updatable = false)
    private Role role;

    public OpenRoleId() {

    }

    public OpenRoleId(Party party, Role role) {
        this.party = party;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }
}
