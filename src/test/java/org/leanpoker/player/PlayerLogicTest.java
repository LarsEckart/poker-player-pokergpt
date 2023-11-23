package org.leanpoker.player;

import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.combinations.SkipCombination;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerLogicTest {


    @Test
    void shouldWeGoAllIn() {
        GameState gameState = new GameState();
        gameState.setPlayers(List.of(
                new Player(
                        new Card("A", "hearts"),
                        new Card("A", "spades"))));

        assertEquals(4000, PlayerLogic.gameLogic(gameState));
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

        return PlayerLogic.shouldGoAllIn(card, card2);
    }
}
