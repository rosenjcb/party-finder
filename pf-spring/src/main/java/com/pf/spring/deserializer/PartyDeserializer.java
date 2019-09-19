/*package com.pf.spring.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.pf.spring.model.Party;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Optional;

public class PartyDeserializer extends StdDeserializer<Party> {

    public PartyDeserializer() {
        this(null);
    }

    public PartyDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Party deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JSONObject json = new JSONObject(jsonParser.readValueAsTree().toString());
        String name = json.optString("name");
    }
}*/
