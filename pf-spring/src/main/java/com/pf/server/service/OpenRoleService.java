package com.pf.server.service;

import com.pf.server.model.OpenRole;
import com.pf.server.model.OpenRoleId;
import com.pf.server.model.Party;
import com.pf.server.model.Role;
import com.pf.server.repository.OpenRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpenRoleService {

    private final OpenRoleRepository openRoleRepository;

    @Autowired
    public OpenRoleService(OpenRoleRepository openRoleRepository) {
        this.openRoleRepository = openRoleRepository;
    }

    public Optional<OpenRole> findByCompositeKey(OpenRoleId openRoleId) {
        return this.openRoleRepository.findById(openRoleId);
    }

    public List<OpenRole> findByPartyAndRole(Party party, Role role) {
        return this.openRoleRepository.findByPartyAndAndRole(party, role);
    }

    public void save(OpenRole openRole) {
        this.openRoleRepository.save(openRole);
    }

    public void remove(OpenRole openRole) {
        this.openRoleRepository.delete(openRole);
    }
}
