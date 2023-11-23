package org.leanpoker.player;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class PlayerLogic {

    private static final Logger log = getLogger(PlayerLogic.class);

    static final int VERSION_NUMBER = 4;
    static final String VERSION = VERSION_NUMBER + " should go all in?";

    // request based on https://leanpoker.org/docs/api/player
    public static int betRequest(JsonNode json) throws JsonProcessingException {
        log.info("betRequest: " + json);
        ObjectMapper objectMapper = new ObjectMapper();
        GameState gameState = objectMapper.readValue(json.toString(), GameState.class);

        if (shouldGoAllIn(gameState)) {
            return 4000;
        }
        return 0;
    }

    private static boolean shouldGoAllIn(GameState gameState) {
        return true;
    }

    public static void showdown(JsonNode game) {
    }
}
