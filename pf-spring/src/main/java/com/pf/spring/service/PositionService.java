package com.pf.spring.service;

import com.pf.spring.model.Position;
import com.pf.spring.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PositionService {

    @Autowired
    PositionRepository positionRepository;

    public void save(Position position) {
        this.positionRepository.save(position);
    }
    public void saveAll(Set<Position> positions) { this.positionRepository.saveAll(positions); }
}
