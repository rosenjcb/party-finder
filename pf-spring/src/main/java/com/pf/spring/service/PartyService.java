package com.pf.spring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pf.spring.model.Party;
import com.pf.spring.model.Position;
import com.pf.spring.model.Role;
import com.pf.spring.repository.PartyRepository;
import com.pf.spring.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class PartyService {

    @Autowired
    PartyRepository partyRepository;

    @Autowired
    RoleService roleService;

    @Autowired
    PositionService positionService;

    ObjectMapper mapper = new ObjectMapper();

    public PartyService() {

    }

    public Party createParty(String name) {
        Party party = new Party(name);
        partyRepository.save(party);
        return party;
    }

    public Party getParty(String partyName) {
        Optional<Party> optionalParty = partyRepository.findPartyByName(partyName);
        return optionalParty.orElse(null);
    }

    public List<Party> getAllParties() {
        return partyRepository.findAll();
    }

    public void save(Party party) {
        partyRepository.save(party);
    }

    public Party updateParty(String partyName, String update) {
        Optional<Party> optionalParty = partyRepository.findPartyByName(partyName);
        if (!optionalParty.isPresent()) return null;
        Party party = optionalParty.get();

        Party updateParty = null;
        try {
            updateParty = mapper.readValue(update, Party.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (!party.getId().equals(updateParty.getId())) try {
            throw new Exception("Party IDs are not the same!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        EntityUtils.copyProperties(updateParty, party);

        //updateParty.getPositions().forEach(position -> System.out.println(position.getId().toString()));
        //Save new set to party and return the party.
        //System.out.println(party.getPositions().stream().count());
        party.getPositions().forEach(position -> {
            System.out.println(position.getParty().getId().toString());
            if (position.getId() != null) {
                System.out.println(position.getId().toString());
            } else {
                System.out.println("ERROR NULL");
            }
        });

        this.save(party);
        return party;
    }
}
