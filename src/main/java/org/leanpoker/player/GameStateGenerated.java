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
    protected Integer round;
    @JsonProperty("players")
    protected List<Player> players;
    @JsonProperty("small_blind")
    protected Integer smallBlind;
    @JsonProperty("big_blind")
    protected Integer bigBlind;
    @JsonProperty("orbits")
    protected Integer orbits;
    @JsonProperty("dealer")
    protected Integer dealer;
    @JsonProperty("community_cards")
    protected List<Object> communityCards;
    @JsonProperty("current_buy_in")
    protected Integer currentBuyIn;
    @JsonProperty("pot")
    protected Integer pot;
    @JsonProperty("in_action")
    protected Integer inAction;
    @JsonProperty("minimum_raise")
    protected Integer minimumRaise;
    @JsonProperty("bet_index")
    protected Integer betIndex;
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
    public Integer getRound() {
        return round;
    }

    @JsonProperty("round")
    public void setRound(Integer round) {
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
    public Integer getSmallBlind() {
        return smallBlind;
    }

    @JsonProperty("small_blind")
    public void setSmallBlind(Integer smallBlind) {
        this.smallBlind = smallBlind;
    }

    @JsonProperty("big_blind")
    public Integer getBigBlind() {
        return bigBlind;
    }

    @JsonProperty("big_blind")
    public void setBigBlind(Integer bigBlind) {
        this.bigBlind = bigBlind;
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

    @JsonProperty("in_action")
    public Integer getInAction() {
        return inAction;
    }

    @JsonProperty("in_action")
    public void setInAction(Integer inAction) {
        this.inAction = inAction;
    }

    @JsonProperty("minimum_raise")
    public Integer getMinimumRaise() {
        return minimumRaise;
    }

    @JsonProperty("minimum_raise")
    public void setMinimumRaise(Integer minimumRaise) {
        this.minimumRaise = minimumRaise;
    }

    @JsonProperty("bet_index")
    public Integer getBetIndex() {
        return betIndex;
    }

    @JsonProperty("bet_index")
    public void setBetIndex(Integer betIndex) {
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
