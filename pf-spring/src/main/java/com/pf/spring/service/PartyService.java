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

    public Party updateParty(String partyName, String update) throws Exception {
        Optional<Party> optionalParty = partyRepository.findPartyByName(partyName);
        if (!optionalParty.isPresent()) return null;
        Party party = optionalParty.get();

        //JSONObject updateJSON = new JSONObject(update);

        Party updateParty = mapper.readValue(update, Party.class);

        if(!party.getName().equals(updateParty.getName())) throw new Exception("Party IDs are not the same!");
        EntityUtils entityUtils = new EntityUtils();
        entityUtils.copyProperties(updateParty, party);

        /*Set<Position> positions = party.getPositions();
        for(int i = 0; i < updateJSON.getJSONArray("positions").length(); i++) {
            Position position = mapper.readValue(updateJSON.getJSONArray("positions").getJSONObject(i).toString(4), Position.class);
            position.setParty(party);
            System.out.println(position.toString());
            positions.add(position);
        }*/

        //positionService.saveAll(positions);

        //Save new set to party and return the party.
        save(party);
        return party;
    }
}
