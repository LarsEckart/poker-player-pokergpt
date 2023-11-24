package org.leanpoker.player;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class PlayerLogic {

    private static final Logger log = getLogger(PlayerLogic.class);

    static final int VERSION_NUMBER = 22;
    static final String VERSION = VERSION_NUMBER + " back to Chen";

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

        if(shouldGoAllInPreFlop(gameState.getOurHoleCards().get(0), gameState.getOurHoleCards().get(1))){
            return 4000;
        }

        return 0;
    }

    public static boolean shouldGoAllInPreFlop(Card card1, Card card2) {
        var sortedCards = sortCards(card1, card2);
        return 7 < ChenFormula.calculate(sortedCards.get(0), sortedCards.get(1));
    }

    private static List<Card> sortCards(Card card1, Card card2) {
        if (card1.asNumber() < card2.asNumber()) {
            return List.of(card2, card1);
        }
        return List.of(card1, card2);
    }

    public static void showdown(JsonNode game) {
    }

}
