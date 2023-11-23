package org.leanpoker.player;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

}
