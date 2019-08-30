package com.pf.spring.repository;

import com.pf.spring.model.PartyMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PartyMemberRepository extends JpaRepository<PartyMember, UUID> {
}
