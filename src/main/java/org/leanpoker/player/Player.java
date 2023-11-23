package org.leanpoker.player;

import com.fasterxml.jackson.databind.JsonNode;

public class Player {

    static final int VERSION_NUMBER = 1;
    static final String VERSION = VERSION_NUMBER + " not folding all in";

    public static int betRequest(JsonNode request) {
        return 4000;
    }

    public static void showdown(JsonNode game) {
    }
}
