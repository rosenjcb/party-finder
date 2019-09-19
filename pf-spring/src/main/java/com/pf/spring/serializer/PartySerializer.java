package com.pf.spring.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.pf.spring.model.Party;
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
        jsonGenerator.writeStringField("id", party.getId().toString());
        jsonGenerator.writeStringField("name", party.getName());
        System.out.println(party.getPositions().size());
        jsonGenerator.writeObjectField("positions", party.getPositions());
        jsonGenerator.writeEndObject();
    }
}
