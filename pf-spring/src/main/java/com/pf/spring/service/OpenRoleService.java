/*package com.pf.spring.service;

import com.pf.spring.model.OpenRole;
import com.pf.spring.model.Party;
import com.pf.spring.model.Role;
import com.pf.spring.repository.OpenRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OpenRoleService {

    private final OpenRoleRepository openRoleRepository;

    @Autowired
    public OpenRoleService(OpenRoleRepository openRoleRepository) {
        this.openRoleRepository = openRoleRepository;
    }

    public Optional<OpenRole> findByCompositeKey(UUID uuid) {
        return this.openRoleRepository.findById(uuid);
    }

    public List<OpenRole> findByPartyAndRole(Party party, Role role) {
        return this.openRoleRepository.findByPartyAndAndRole(party, role);
    }

    public long countByPartyAndRole(Party party, Role role) {
        return this.openRoleRepository.countByPartyAndRole(party, role);
    }

    public void save(OpenRole openRole) {
        this.openRoleRepository.save(openRole);
    }

    public void remove(OpenRole openRole) {
        this.openRoleRepository.delete(openRole);
    }
}*/
