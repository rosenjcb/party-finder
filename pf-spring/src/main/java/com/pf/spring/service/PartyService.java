package com.pf.spring.service;

import com.pf.spring.model.Party;
import com.pf.spring.model.PartyMember;
import com.pf.spring.model.Role;
import com.pf.spring.repository.PartyRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PartyService {

    @Autowired
    PartyRepository partyRepository;

    @Autowired
    RoleService roleService;

    @Autowired
    PartyMemberService partyMemberService;

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

    public Party updateParty(String partyName, String update) {
        Optional<Party> optionalParty = partyRepository.findPartyByName(partyName);
        if (!optionalParty.isPresent()) return null;
        Party party = optionalParty.get();

        HashMap<String, Role> roleHashMap = roleService.getRoleMappings();
        JSONObject updateJSON = new JSONObject(update);

        Set<PartyMember> partyMembers = party.getPartyMembers();
        for(int i = 0; i < updateJSON.getJSONArray("addRoles").length(); i++) {
            PartyMember partyMember = new PartyMember(party, roleHashMap.get(updateJSON.getJSONArray("addRoles").getString(i)));
            System.out.println(partyMember.toString());
            partyMembers.add(partyMember);
            partyMemberService.save(partyMember);
        }

        //Save new set to party and return the party.
        //party.setOpenRoles(openRoles);
        return party;
    }
}
