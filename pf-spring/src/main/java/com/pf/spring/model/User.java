package com.pf.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.UUID;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String username;

    @OneToMany(mappedBy = "user")
    private Set<PartyMember> partyMembers;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public Set<PartyMember> getPartyMembers() {
        return partyMembers;
    }

    public void setPartyMembers(Set<PartyMember> partyMembers) {
        this.partyMembers = partyMembers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
