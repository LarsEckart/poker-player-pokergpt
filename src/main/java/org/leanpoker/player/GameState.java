package org.leanpoker.player;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GameState extends GameStateGenerated {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    public static GameState load(String json) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(json, GameState.class);
    }

    public Player getUs() {
        return this.players.get(this.getInAction());
    }

    public Status asStatus() {
        Integer ourIndex = this.getInAction();
        Integer dealerIndex = this.getDealer();
        int totalPlayers = this.getPlayers().size();

        return getStatus(ourIndex, dealerIndex, totalPlayers);
    }

    public static Status getStatus(Integer ourIndex, Integer dealerIndex, int totalPlayers) {
        dealerIndex = dealerIndex + 2;
        int ourPositionFromDealer;
        if (ourIndex == dealerIndex) {
            ourPositionFromDealer = totalPlayers;
        } else if (ourIndex < dealerIndex) {
            ourPositionFromDealer = (totalPlayers + ourIndex) - dealerIndex;
        } else {
            ourPositionFromDealer = ourIndex - dealerIndex;
        }

        return new Status(ourPositionFromDealer, totalPlayers, 0);
    }

    private int ourPosition(int dealer, int ourIndex) {
        return (ourIndex - dealer + 4) % 4;
    }
}
