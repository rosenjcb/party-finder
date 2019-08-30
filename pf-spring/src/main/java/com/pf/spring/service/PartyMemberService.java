package com.pf.spring.service;

import com.pf.spring.model.PartyMember;
import com.pf.spring.repository.PartyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyMemberService {

    @Autowired
    PartyMemberRepository partyMemberRepository;

    public void save(PartyMember partyMember) {
        this.partyMemberRepository.save(partyMember);
    }
}
