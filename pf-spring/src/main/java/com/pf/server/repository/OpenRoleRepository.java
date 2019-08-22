package com.pf.server.repository;

import com.pf.server.model.OpenRole;
import com.pf.server.model.OpenRoleId;
import com.pf.server.model.Party;
import com.pf.server.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OpenRoleRepository extends JpaRepository<OpenRole, OpenRoleId> {

    Optional<OpenRole> findById(OpenRoleId openRoleId);
    List<OpenRole> findByPartyAndAndRole(Party party, Role role);
}
