package com.pf.spring.controller;

import com.pf.spring.repository.SkillRepository;
import com.pf.spring.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SkillController {

    @Autowired private SkillService skillService;

    @RequestMapping(method = RequestMethod.POST, name = "/skill", produces = "application/json")
    public ResponseEntity<String> createSkill(@RequestBody String skill) {
        skillService.createSkill(skill);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
