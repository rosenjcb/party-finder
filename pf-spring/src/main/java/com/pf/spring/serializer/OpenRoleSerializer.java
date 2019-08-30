/*
package com.pf.spring.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.pf.spring.model.OpenRole;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class OpenRoleSerializer extends StdSerializer<OpenRole> {

    public OpenRoleSerializer() {
        this(null);
    }

    public OpenRoleSerializer(Class<OpenRole> t) {
        super(t);
    }

    @Override
    public void serialize(OpenRole openRole, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        //jsonGenerator.writeStringField(openRole.getRole().getRoleName(), Integer.toString(openRole.getQuantity()));
        jsonGenerator.writeEndObject();
    }
}
*/
