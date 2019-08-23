package com.pf.server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pf.server.model.Party;
import com.pf.server.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PartyController {

    private final PartyService partyService;

    @Autowired
    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createParty", produces = "application/json")
    public ResponseEntity<Party> createParty(@RequestBody String partyInfo) {
        Party party = partyService.createParty(partyInfo);
        return new ResponseEntity<>(party, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/parties", produces = "application/json")
    public ResponseEntity<?> getAllParties() {
        List<Party> parties = partyService.getAllParties();
        return new ResponseEntity<>(parties, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/parties/{id}",  produces = "application/json")
    public ResponseEntity<?> getParty(@PathVariable int id) throws JsonProcessingException {
        Party party = partyService.getParty(id);
        //ObjectMapper mapper = new ObjectMapper();
        //String response = mapper.writeValueAsString(party);
        //System.out.println(party.getName());
        return party != null ? new ResponseEntity<>(party, HttpStatus.ACCEPTED) : new ResponseEntity<>("Party not found.", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/parties/{id}", produces = "application/json")
    public ResponseEntity<?> updateParty(@RequestBody String update, @PathVariable int id) {
        Party party = partyService.updateParty(id, update);
        return party != null ? new ResponseEntity<>(party, HttpStatus.ACCEPTED) : new ResponseEntity<>("Party not found or update malformed.", HttpStatus.BAD_REQUEST);
    }


}
