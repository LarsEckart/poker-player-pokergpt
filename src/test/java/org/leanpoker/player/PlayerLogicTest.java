package org.leanpoker.player;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerLogicTest {


    @Test
    void whenPairThenAllIn() {
        GameState gameState = new GameState();
        gameState.setPlayers(List.of(
                new Player(
                        new Card("6", "hearts"),
                        new Card("10", "spades"))));

        assertEquals(4000, PlayerLogic.gameLogic(gameState));
    }

}
