package com.pf.spring.service;

import com.pf.spring.model.Position;
import com.pf.spring.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class PositionService {

    @Autowired
    PositionRepository positionRepository;

    public void save(Position position) {
        this.positionRepository.save(position);
    }

    public Position getPositionById(String partyName, UUID positionId) throws Exception {
        Optional<Position> optPosition =  positionRepository.findPositionById(positionId);
        optPosition.orElseThrow(() -> new Exception("Cannot find Position with UUID: " + positionId.toString()));
        Position position = optPosition.get();
        if(!position.getParty().getName().equals(partyName)) throw new Exception("Position is not from party: " + position.getParty().getName());
        return position;
    }
    public void saveAll(Set<Position> positions) { this.positionRepository.saveAll(positions); }
}
