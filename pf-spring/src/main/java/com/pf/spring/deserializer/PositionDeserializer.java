package com.pf.spring.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.pf.spring.model.Party;
import com.pf.spring.model.Position;
import com.pf.spring.model.Role;
import com.pf.spring.service.RoleService;
import com.pf.spring.util.BeanUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.io.IOException;
import java.util.HashMap;

public class PositionDeserializer extends StdDeserializer<Position> {

    RoleService roleService = BeanUtils.getBean(RoleService.class);
    HashMap<String, Role> roleHashMap = roleService.getRoleMappings();

    public PositionDeserializer() {
        this(null);
    }

    public PositionDeserializer(Class<?> vc) {
        super(vc);
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public Position deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JSONObject json = new JSONObject(jsonParser.readValueAsTree().toString());
        Role role = roleHashMap.get(json.getString("role"));
        boolean hasCompensation = json.optBoolean("hasCompensation");
        boolean hasEquity = json.optBoolean("hasEquity");

        if (json.has("skills") && json.has("hasCompensation") && json.has("hasEquity")) {
            return null; //return new Position(null, role, json.getString("hasCompensation"), json.getString("hasEquity"))
        } else {
            return new Position(null, role, hasCompensation, hasEquity);
        }
    }
}
