package com.pf.spring.controller;

import com.pf.spring.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PositionController {
    @Autowired
    PositionService positionService;

    @RequestMapping(method = RequestMethod.GET, value="/parties/{partyName}/positions/{positionId}")
    public ResponseEntity<?> getPosition(@PathVariable String partyName, @PathVariable UUID positionId) {
        try {
            return new ResponseEntity<>(positionService.getPositionById(partyName, positionId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
