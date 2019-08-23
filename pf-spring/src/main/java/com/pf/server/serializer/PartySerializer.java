package com.pf.server.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.pf.server.model.OpenRole;
import com.pf.server.model.Party;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class PartySerializer extends StdSerializer<Party> {

    public PartySerializer() {
        this(null);
    }

    public PartySerializer(Class<Party> t) {
        super(t);
    }

    @Override
    public void serialize(Party party, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name", party.getName());
        jsonGenerator.writeObjectField("openRoles", party.getOpenRoles());
        jsonGenerator.writeEndObject();
    }
}
