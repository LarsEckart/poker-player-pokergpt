package org.leanpoker.player;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.approvaltests.JsonJacksonApprovals;
import org.junit.jupiter.api.Test;

class GameStateTest {

    @Test
    void findUs() throws JsonProcessingException {
        GameState gameState = loadGameState();

        Player us = gameState.getUs();

        JsonJacksonApprovals.verifyAsJson(us);
    }

    private static GameState loadGameState() throws JsonProcessingException {
        String json = """
                {
                  "tournament_id": "655e6ea29c97ef0002da0843",
                  "game_id": "655f52735485f700028038f1",
                  "round": 17,
                  "players": [
                    {
                      "name": "Charming Rabbit",
                      "stack": 956,
                      "status": "active",
                      "bet": 6,
                      "time_used": 4818862,
                      "version": "Default Python folding player",
                      "id": 0
                    },
                    {
                      "name": "PokerGPT",
                      "stack": 2080,
                      "status": "active",
                      "bet": 0,
                      "hole_cards": [
                        {
                          "rank": "4",
                          "suit": "diamonds"
                        },
                        {
                          "rank": "9",
                          "suit": "hearts"
                        }
                      ],
                      "time_used": 4864095,
                      "version": "5 with a test",
                      "id": 1
                    },
                    {
                      "name": "Green Rabbits",
                      "stack": 0,
                      "status": "out",
                      "bet": 0,
                      "time_used": 283949,
                      "version": "2 - with sysout",
                      "id": 2
                    },
                    {
                      "name": "The Semiprofessionals",
                      "stack": 955,
                      "status": "active",
                      "bet": 3,
                      "time_used": 4840898,
                      "version": "Kotlin Player 0.0.1",
                      "id": 3
                    }
                  ],
                  "small_blind": 3,
                  "big_blind": 6,
                  "orbits": 4,
                  "dealer": 1,
                  "community_cards": [],
                  "current_buy_in": 6,
                  "pot": 9,
                  "in_action": 1,
                  "minimum_raise": 3,
                  "bet_index": 2
                }
                """;

        return GameState.load(json);
    }

}
