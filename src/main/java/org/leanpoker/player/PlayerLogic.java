package org.leanpoker.player;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class PlayerLogic {

    private static final Logger log = getLogger(PlayerLogic.class);

    static final int VERSION_NUMBER = 3;
    static final String VERSION = VERSION_NUMBER + " not folding all in with logging and json parsing";

    // request based on https://leanpoker.org/docs/api/player
    public static int betRequest(JsonNode request) throws JsonProcessingException {
        log.info("betRequest: " + request);
        ObjectMapper objectMapper = new ObjectMapper();
        Request request1 = objectMapper.readValue(request.toString(), Request.class);

        return 4000;
    }

    public static void showdown(JsonNode game) {
    }
}
