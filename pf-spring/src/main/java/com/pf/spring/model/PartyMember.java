package com.pf.spring.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pf.spring.serializer.PartyMemberSerializer;
import com.pf.spring.serializer.PartySerializer;

import javax.persistence.*;
import java.util.Base64;
import java.util.UUID;

@Entity(name  = "party_members")
@JsonSerialize(using = PartyMemberSerializer.class)
public class PartyMember {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name =  "party_id")
    private Party party;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    private boolean isEmpty;

    private PartyMember() {
        this.isEmpty = true;
    }

    public PartyMember(Party party, Role role) {
        this.party = party;
        this.role = role;
        this.isEmpty = true;
    }

    private PartyMember(Party party, User user, Role role) {
        this.party = party;
        this.user = user;
        this.role = role;
        this.isEmpty = false;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append("id = " + id.toString()).append("\n");
        sb.append("party = " + party.getName()).append("\n");
        sb.append("role = " + role.getRoleName()).append("\n");
        if(user != null) sb.append("user = " + user.getUsername()).append("\n");
        sb.append("isEmpty = " + isEmpty).append("\n");
        return sb.toString();
    }
}
