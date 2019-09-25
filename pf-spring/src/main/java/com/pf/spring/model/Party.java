package com.pf.spring.model;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pf.spring.serializer.PartySerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "parties")
@JsonSerialize(using = PartySerializer.class)
public class Party implements Serializable {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "party", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Position> positions = new HashSet<>();

    public Party() {

    }

    public Party(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions.clear();
        if(positions != null) {
            positions.forEach(position ->  position.setParty(this));
            this.positions.addAll(positions);
        }
    }
}
