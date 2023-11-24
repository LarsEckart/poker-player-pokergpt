package org.leanpoker.player;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.lambda.query.Queryable;

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

        int bidCount = Queryable.as(this.getPlayers()).where(p -> this.getBigBlind() < p.getBet()).size();

        return getStatus(ourIndex, dealerIndex, totalPlayers, bidCount);
    }

    public static Status getStatus(Integer ourIndex, Integer dealerIndex, int totalPlayers, int bidCount) {
        int firstPlayerIndex = (dealerIndex + 3) % totalPlayers;


        for (int i = 0; i < totalPlayers; i++) {
            if ((firstPlayerIndex + i) % totalPlayers == ourIndex) {
                return new Status(i + 1, totalPlayers, bidCount);
            }
        }
        return null;
    }
}
