package org.leanpoker.player;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class PlayerLogic {

    private static final Logger log = getLogger(PlayerLogic.class);

    static final int VERSION_NUMBER = 24;
    static final String VERSION = VERSION_NUMBER + " late game destroyer";

    // request based on https://leanpoker.org/docs/api/player
    public static int betRequest(JsonNode json) throws JsonProcessingException {
        log.info("betRequest: " + json);
        GameState gameState = GameState.load(json.toString());

        return gameLogic(gameState);
    }

    public static int gameLogic(GameState gameState) {
        if (gameState.isFirstRound() && !gameState.potIsBig()) {
            return gameState.getCurrentBuyIn() + gameState.getMinimumRaise() * 2;
        }

        if (gameState.weHavePair() && 8 < gameState.getOurHoleCards().get(0).asNumber()) {
            return 4000;
        }

        int chenScore = gameState.calculateChenScore();
        if (30 < gameState.getBigBlind()) {
            if (10 <= chenScore) {
                return 4000;
            }
        } else {
            if (gameState.weHavePair()) {
                return 4000;
            }
        }

        return 0;
    }

    public static void showdown(JsonNode game) {
    }

}
