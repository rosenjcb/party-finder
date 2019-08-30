package com.pf.spring.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.pf.spring.model.Party;
import com.pf.spring.model.PartyMember;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class PartyMemberSerializer extends StdSerializer<PartyMember> {

    PartyMemberSerializer() {
        this(null);
    }

    PartyMemberSerializer(Class<PartyMember> t) {
        super(t);
    }

    @Override
    public void serialize(PartyMember partyMember, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", partyMember.getId().toString());
        jsonGenerator.writeStringField("role", partyMember.getRole().getRoleName());
        if(partyMember.getUser() != null) jsonGenerator.writeStringField("user", partyMember.getUser().getUsername());
        else if(partyMember.isEmpty()) jsonGenerator.writeStringField("status", "open");
        jsonGenerator.writeEndObject();
    }
}
