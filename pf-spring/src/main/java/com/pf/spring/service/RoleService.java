package com.pf.spring.service;

import com.pf.spring.model.Role;
import com.pf.spring.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;


    public RoleService() {

    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public HashMap<String, Role> getRoleMappings() {
        HashMap<String, Role> roleMappings = new HashMap<>();
        List<Role> roles = roleRepository.findAll();
        roles.forEach( role -> roleMappings.put(role.getRoleName(), role));

        return roleMappings;
    }

    /*public List<Role> findPartyIdAndRoleId(int partyId, int roleId) {
        return roleRepository.findPartyIdAndRoleId(partyId, roleId);
    }*/
}
