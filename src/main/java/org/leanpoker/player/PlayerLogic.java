package org.leanpoker.player;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class PlayerLogic {

    private static final Logger log = getLogger(PlayerLogic.class);

    static final int VERSION_NUMBER = 12;
    static final String VERSION = VERSION_NUMBER + " . r separate generated code";

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
        return shouldGoAllInPreFlop(holeCards.get(0), holeCards.get(1));
    }

    public static boolean shouldGoAllInPreFlop(Card card1, Card card2) {
        var sortedCards = sortCards(card1, card2);
//        return card1.asNumber() == card2.asNumber() || 10 <= card1.asNumber();
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

    private static double calculateChenScore(Card card) {
        String rank = card.rank();
        double score;

        switch (rank) {
            case "Ace":
                score = 10;
                break;
            case "King":
                score = 8;
                break;
            case "Queen":
                score = 7;
                break;
            case "Jack":
                score = 6;
                break;
            case "10":
                score = 5;
                break;
            case "9":
                score = 4.5;
                break;
            case "8":
                score = 4;
                break;
            case "7":
                score = 3.5;
                break;
            case "6":
                score = 3;
                break;
            case "5":
                score = 2.5;
                break;
            case "4":
                score = 2;
                break;
            case "3":
                score = 1.5;
                break;
            case "2":
                score = 1;
                break;
            default:
                score = 0; // For any unexpected rank
        }

        // Additional logic for suited cards or other considerations can be added here
        // For example, if the card is suited, you might want to add 2 to the score

        return score;
    }

}
