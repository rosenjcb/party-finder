package com.pf.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pf.spring.deserializer.PositionDeserializer;
import com.pf.spring.serializer.PositionSerializer;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity(name = "positions")
@JsonSerialize(using = PositionSerializer.class)
@JsonDeserialize(using = PositionDeserializer.class)
public class Position {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "party_id")
    @JsonIgnore
    private Party party;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(
            fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    private boolean isOpen = true;

    private boolean hasCompensation = false;

    private boolean hasEquity = false;

    /*@ManyToMany
    @JoinTable(
            name = "position_skill_map",
            joinColumns = @JoinColumn(name = "position_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> skills;*/


    private Position() {
    }


    public Position(Party party, Role role) {
        this.party = party;
        this.role = role;
        this.isOpen = true;
    }

    public Position(String id, Party party, Role role) {
        this.id = UUID.fromString(id);
        this.party = party;
        this.role = role;
        this.isOpen = true;
    }

    public Position(Party party, Role role, boolean hasCompensation, boolean hasEquity) {
        this.party = party;
        this.role = role;
        this.hasCompensation = hasCompensation;
        this.hasEquity = hasEquity;
        this.isOpen = true;
    }

    public Position(String id, Party party, Role role, boolean hasCompensation, boolean hasEquity) {
        if(!id.isEmpty()) this.id = UUID.fromString(id);
        this.party = party;
        this.role = role;
        this.hasCompensation = hasCompensation;
        this.hasEquity = hasEquity;
        this.isOpen = true;
    }


    /*public Position(Party party, Role role, boolean hasCompensation, boolean hasEquity, Set<Skill> skills) {
        this.party = party;
        this.role = role;
        this.hasCompensation = hasCompensation;
        this.hasEquity = hasEquity;
        this.skills = skills;
        this.isOpen = true;
    }*/

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

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append("id = " + id.toString()).append("\n");
        sb.append("party = " + party.getName()).append("\n");
        sb.append("role = " + role.getRoleName()).append("\n");
        if (user != null) sb.append("user = " + user.getUsername()).append("\n");
        sb.append("isOpen = " + isOpen).append("\n");
        return sb.toString();
    }

    public boolean getHasCompensation() {
        return hasCompensation;
    }

    public void setHasCompensation(boolean hasCompensation) {
        this.hasCompensation = hasCompensation;
    }

    public boolean getHasEquity() {
        return hasEquity;
    }

    public void setHasEquity(boolean hasEquity) {
        this.hasEquity = hasEquity;
    }

    /*public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }*/

    /*@Override
    public boolean equals(Object object) {
        Party party = (Party) object;
        return super.equals(this.getId() == party.getId());
    }*/
}
