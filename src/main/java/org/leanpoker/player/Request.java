package org.leanpoker.player;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Request {

    @JsonProperty("players")
    private List<Player> players;
    @JsonProperty("tournament_id")
    private String tournamentId;
    @JsonProperty("game_id")
    private String gameId;
    @JsonProperty("round")
    private Integer round;
    @JsonProperty("bet_index")
    private Integer betIndex;
    @JsonProperty("small_blind")
    private Integer smallBlind;
    @JsonProperty("orbits")
    private Integer orbits;
    @JsonProperty("dealer")
    private Integer dealer;
    @JsonProperty("community_cards")
    private List<Object> communityCards;
    @JsonProperty("current_buy_in")
    private Integer currentBuyIn;
    @JsonProperty("pot")
    private Integer pot;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("players")
    public List<Player> getPlayers() {
        return players;
    }

    @JsonProperty("players")
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

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
    public Integer getRound() {
        return round;
    }

    @JsonProperty("round")
    public void setRound(Integer round) {
        this.round = round;
    }

    @JsonProperty("bet_index")
    public Integer getBetIndex() {
        return betIndex;
    }

    @JsonProperty("bet_index")
    public void setBetIndex(Integer betIndex) {
        this.betIndex = betIndex;
    }

    @JsonProperty("small_blind")
    public Integer getSmallBlind() {
        return smallBlind;
    }

    @JsonProperty("small_blind")
    public void setSmallBlind(Integer smallBlind) {
        this.smallBlind = smallBlind;
    }

    @JsonProperty("orbits")
    public Integer getOrbits() {
        return orbits;
    }

    @JsonProperty("orbits")
    public void setOrbits(Integer orbits) {
        this.orbits = orbits;
    }

    @JsonProperty("dealer")
    public Integer getDealer() {
        return dealer;
    }

    @JsonProperty("dealer")
    public void setDealer(Integer dealer) {
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
    public Integer getCurrentBuyIn() {
        return currentBuyIn;
    }

    @JsonProperty("current_buy_in")
    public void setCurrentBuyIn(Integer currentBuyIn) {
        this.currentBuyIn = currentBuyIn;
    }

    @JsonProperty("pot")
    public Integer getPot() {
        return pot;
    }

    @JsonProperty("pot")
    public void setPot(Integer pot) {
        this.pot = pot;
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
