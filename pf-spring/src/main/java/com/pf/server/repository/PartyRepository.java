package com.pf.server.repository;

import com.pf.server.model.OpenRoleId;
import com.pf.server.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartyRepository extends JpaRepository<Party, Integer> {
}
