package com.pf.spring.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.pf.spring.model.Position;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class PositionSerializer extends StdSerializer<Position> {

    PositionSerializer() {
        this(null);
    }

    PositionSerializer(Class<Position> t) {
        super(t);
    }

    @Override
    public void serialize(Position position, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", position.getId().toString());
        jsonGenerator.writeStringField("role", position.getRole().getRoleName());
        jsonGenerator.writeBooleanField("hasCompensation", position.getHasCompensation());
        jsonGenerator.writeBooleanField("hasEquity", position.getHasEquity());
        if(position.getUser() != null) jsonGenerator.writeStringField("user", position.getUser().getUsername());
        else if(position.isOpen()) jsonGenerator.writeStringField("status", "open");
        jsonGenerator.writeEndObject();
    }
}
