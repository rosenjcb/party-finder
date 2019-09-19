package com.pf.spring.service;

import com.pf.spring.model.Skill;
import com.pf.spring.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

    @Autowired private SkillRepository skillRepository;

    public void createSkill(String name) {
        Skill skill = new Skill(name);
        skillRepository.save(skill);
    }
}
