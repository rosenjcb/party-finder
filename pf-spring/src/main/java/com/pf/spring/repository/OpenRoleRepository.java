/*package com.pf.spring.repository;

import com.pf.spring.model.OpenRole;
import com.pf.spring.model.Party;
import com.pf.spring.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OpenRoleRepository extends JpaRepository<OpenRole, UUID> {

    Optional<OpenRole> findById(UUID uuid);
    List<OpenRole> findByPartyAndAndRole(Party party, Role role);
    long countByPartyAndRole(Party party, Role Role);
}*/
