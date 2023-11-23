package org.leanpoker.player;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GameState extends GameStateGenerated {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    public static GameState load(String json) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(json, GameState.class);
    }

    public Player getUs() {
        return this.players.first(p -> p.getName().equals("PokerGPT"));
    }

    public Status asStatus() {
        return new Status();
    }
}
