package com.pf.server.service;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pf.server.model.OpenRole;
import com.pf.server.model.OpenRoleId;
import com.pf.server.model.Party;
import com.pf.server.model.Role;
import com.pf.server.repository.PartyRepository;
import com.pf.server.repository.RoleRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PartyService {

    @Autowired
    PartyRepository partyRepository;

    @Autowired
    OpenRoleService openRoleService;

    @Autowired
    RoleService roleService;

    public PartyService() {

    }

    public Party createParty(String name) {
        Party party = new Party(name);
        partyRepository.save(party);
        return party;
    }

    public Party getParty(int id) {
        Optional<Party> optionalParty = partyRepository.findById(id);
        return optionalParty.orElse(null);
    }

    public Party updateParty(int id, String update) {
        Optional<Party> optionalParty = partyRepository.findById(id);
        if (!optionalParty.isPresent()) return null;
        Party party = optionalParty.get();

        HashMap<String, Role> roleHashMap = roleService.getRoleMappings();
        JSONObject updateJSON = new JSONObject(update);

        //Collect all unmodified openRoles into new set.
        Set<OpenRole> openRoles = party.getOpenRoles().stream().filter(openRole -> updateJSON.keySet().stream().noneMatch(key -> key.equals(openRole.getRole().getRoleName()))).collect(Collectors.toSet());

        //Modify openRoles and add them to the new set.
        for (String key : updateJSON.keySet()) {
            Optional<OpenRole> optionalOpenRole = this.openRoleService.findByCompositeKey(new OpenRoleId(party, roleHashMap.get(key)));
            optionalOpenRole.ifPresent(openRole -> {
                openRole.setQuantity(updateJSON.getInt(key));
                openRoles.add(openRole);
                openRoleService.save(openRole);
            });

            if(!optionalOpenRole.isPresent()) {
                OpenRole openRole = new OpenRole(party, roleHashMap.get(key), updateJSON.getInt(key));
                openRoles.add(openRole);
                openRoleService.save(openRole);
            }
        }

        //Save new set to party and return the party.
        party.setOpenRoles(openRoles);
        return party;
    }
}
