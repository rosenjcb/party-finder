package com.pf.spring.repository;

import com.pf.spring.model.Position;
import com.pf.spring.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SkillRepository extends JpaRepository<Skill, Long> {
}