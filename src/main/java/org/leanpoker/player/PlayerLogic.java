package org.leanpoker.player;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class PlayerLogic {

    private static final Logger log = getLogger(PlayerLogic.class);

    static final int VERSION_NUMBER = 8;
    static final String VERSION = VERSION_NUMBER + " with test for everything";

    // request based on https://leanpoker.org/docs/api/player
    public static int betRequest(JsonNode json) throws JsonProcessingException {
        log.info("betRequest: " + json);
        GameState gameState = GameState.load(json.toString());

        return gameLogic(gameState);
    }

    public static int gameLogic(GameState gameState) {
        if (shouldGoAllIn(gameState)) {
            return 4000;
        }
        return 0;
    }

    private static boolean shouldGoAllIn(GameState gameState) {
        List<Card> holeCards = gameState.getUs().getHoleCards();
        if (holeCards.size() != 2) {
            return true;
        }
        return shouldGoAllIn(holeCards.get(0), holeCards.get(1));
    }

    public static boolean shouldGoAllIn(Card card, Card card1) {
        return true;
    }

    public static void showdown(JsonNode game) {
    }
}
