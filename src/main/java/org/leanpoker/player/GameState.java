package org.leanpoker.player;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.lambda.query.Queryable;

import java.util.List;

public class GameState extends GameStateGenerated {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    public static GameState load(String json) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(json, GameState.class);
    }

    public boolean potIsBig() {
        return getBigBlind() * 3 < getPot();
    }

    @JsonIgnore
    public List<Card> getOurHoleCards() {
        return getUs().getHoleCards();
    }

    public boolean haveSemiprofessionalsBid() {
        Player semiprofessionals = Queryable.as(players).first(p -> p.getName().contains("The Semiprofessionals"));

        return getBigBlind() < semiprofessionals.getBet();
    }

    public boolean weHavePair() {
        return getUs().getHoleCards().get(0).asNumber() == getUs().getHoleCards().get(1).asNumber();
    }

    @JsonIgnore
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

    @JsonIgnore
    public boolean isFirstRound() {
        return this.getUs().getBet() <= this.getBigBlind();
    }

    public int calculateChenScore() {
        return (int) ChenFormula.calculate(getOurHoleCards().get(0), getOurHoleCards().get(1));
    }

    @JsonIgnore
    public PlayerGenerated getPlayerAt(int index) {
        return this.getPlayers().get(index % this.getPlayers().size());
    }
}
