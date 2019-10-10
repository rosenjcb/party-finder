package com.pf.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pf.spring.model.Party;
import com.pf.spring.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PartyController {

    private final PartyService partyService;

    @Autowired
    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/parties", produces = "application/json")
    public ResponseEntity<?> createParty(@RequestBody Party party) {
        partyService.createParty(party);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}").buildAndExpand(party.getName()).toUri();
        System.out.println(uri.toString());
        return new ResponseEntity<>(uri, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/parties", produces = "application/json")
    public ResponseEntity<?> getAllParties() {
        List<Party> parties = partyService.getAllParties();
        return new ResponseEntity<>(parties, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/parties/{partyName}",  produces = "application/json")
    public ResponseEntity<?> getParty(@PathVariable String partyName) throws JsonProcessingException {
        Party party = partyService.getParty(partyName);
        return party != null ? new ResponseEntity<>(party, HttpStatus.ACCEPTED) : new ResponseEntity<>("Party not found.", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/parties/{partyName}", produces = "application/json")
    public ResponseEntity<?> updateParty(@RequestBody String update, @PathVariable String partyName) {
        try {
            Party party = partyService.updateParty(partyName, update);
            return new ResponseEntity<>(party, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
