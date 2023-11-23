package org.leanpoker.player;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class Player {

    private static final Logger log = getLogger(Player.class);

    static final int VERSION_NUMBER = 2;
    static final String VERSION = VERSION_NUMBER + " not folding all in with logging";

    public static int betRequest(JsonNode request) {
        log.info("betRequest: " + request);
        return 4000;
    }

    public static void showdown(JsonNode game) {
    }
}
