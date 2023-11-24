package org.leanpoker.player;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.combinations.SkipCombination;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.leanpoker.player.GameStateTest.loadGameState;

class PlayerLogicTest {


    @Test
    void shouldWeGoAllIn() throws JsonProcessingException {
        GameState gameState = loadGameState();
        gameState.getUs().setHoleCards(
                List.of(
                        new Card("A", "hearts"),
                        new Card("A", "spades")));

        assertEquals(6, PlayerLogic.gameLogic(gameState));
    }

    @Test
    void name() {
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                "J", "Q", "K", "A"};
        String[] suits = {"hearts", "spades", "diamonds", "clubs"};

        CombinationApprovals.verifyAllCombinations(
                PlayerLogicTest::assessStartingHand,
                numbers, suits, numbers, suits);
    }

    public static boolean assessStartingHand(String number1, String suit1, String number2, String suit2) {
        Card card = new Card(number1, suit1);
        Card card2 = new Card(number2, suit2);
        if (card.equals(card2)) {
            throw new SkipCombination();
        }

        return PlayerLogic.shouldGoAllInPreFlop(card, card2);
    }
}
