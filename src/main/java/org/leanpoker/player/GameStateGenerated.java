package org.leanpoker.player;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameStateGenerated {

    @JsonProperty("tournament_id")
    protected String tournamentId;
    @JsonProperty("game_id")
    protected String gameId;
    @JsonProperty("round")
    protected int round;
    @JsonProperty("players")
    protected List<Player> players;
    @JsonProperty("small_blind")
    protected int smallBlind;
    @JsonProperty("big_blind")
    protected int bigBlind;
    @JsonProperty("orbits")
    protected int orbits;
    @JsonProperty("dealer")
    protected int dealer;
    @JsonProperty("community_cards")
    protected List<Object> communityCards;
    @JsonProperty("current_buy_in")
    protected int currentBuyIn;
    @JsonProperty("pot")
    protected int pot;
    @JsonProperty("in_action")
    protected int inAction;
    @JsonProperty("minimum_raise")
    protected int minimumRaise;
    @JsonProperty("bet_index")
    protected int betIndex;
    @JsonIgnore
    protected Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("tournament_id")
    public String getTournamentId() {
        return tournamentId;
    }

    @JsonProperty("tournament_id")
    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    @JsonProperty("game_id")
    public String getGameId() {
        return gameId;
    }

    @JsonProperty("game_id")
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    @JsonProperty("round")
    public int getRound() {
        return round;
    }

    @JsonProperty("round")
    public void setRound(int round) {
        this.round = round;
    }

    @JsonProperty("players")
    public List<Player> getPlayers() {
        return players;
    }

    @JsonProperty("players")
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @JsonProperty("small_blind")
    public int getSmallBlind() {
        return smallBlind;
    }

    @JsonProperty("small_blind")
    public void setSmallBlind(int smallBlind) {
        this.smallBlind = smallBlind;
    }

    @JsonProperty("big_blind")
    public int getBigBlind() {
        return bigBlind;
    }

    @JsonProperty("big_blind")
    public void setBigBlind(int bigBlind) {
        this.bigBlind = bigBlind;
    }

    @JsonProperty("orbits")
    public int getOrbits() {
        return orbits;
    }

    @JsonProperty("orbits")
    public void setOrbits(int orbits) {
        this.orbits = orbits;
    }

    @JsonProperty("dealer")
    public int getDealer() {
        return dealer;
    }

    @JsonProperty("dealer")
    public void setDealer(int dealer) {
        this.dealer = dealer;
    }

    @JsonProperty("community_cards")
    public List<Object> getCommunityCards() {
        return communityCards;
    }

    @JsonProperty("community_cards")
    public void setCommunityCards(List<Object> communityCards) {
        this.communityCards = communityCards;
    }

    @JsonProperty("current_buy_in")
    public int getCurrentBuyIn() {
        return currentBuyIn;
    }

    @JsonProperty("current_buy_in")
    public void setCurrentBuyIn(int currentBuyIn) {
        this.currentBuyIn = currentBuyIn;
    }

    @JsonProperty("pot")
    public int getPot() {
        return pot;
    }

    @JsonProperty("pot")
    public void setPot(int pot) {
        this.pot = pot;
    }

    @JsonProperty("in_action")
    public int getInAction() {
        return inAction;
    }

    @JsonProperty("in_action")
    public void setInAction(int inAction) {
        this.inAction = inAction;
    }

    @JsonProperty("minimum_raise")
    public int getMinimumRaise() {
        return minimumRaise;
    }

    @JsonProperty("minimum_raise")
    public void setMinimumRaise(int minimumRaise) {
        this.minimumRaise = minimumRaise;
    }

    @JsonProperty("bet_index")
    public int getBetIndex() {
        return betIndex;
    }

    @JsonProperty("bet_index")
    public void setBetIndex(int betIndex) {
        this.betIndex = betIndex;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
