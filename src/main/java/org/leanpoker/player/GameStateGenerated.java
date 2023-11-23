package org.leanpoker.player;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.lambda.query.Queryable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameStateGenerated {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @JsonProperty("players")
    protected Queryable<Player> players;
    @JsonProperty("tournament_id")
    protected String tournamentId;
    @JsonProperty("game_id")
    protected String gameId;
    @JsonProperty("round")
    protected Integer round;
    @JsonProperty("bet_index")
    protected Integer betIndex;
    @JsonProperty("small_blind")
    protected Integer smallBlind;
    @JsonProperty("orbits")
    protected Integer orbits;
    @JsonProperty("dealer")
    protected Integer dealer;
    @JsonProperty("community_cards")
    protected List<Card> communityCards;
    @JsonProperty("current_buy_in")
    protected Integer currentBuyIn;
    @JsonProperty("pot")
    protected Integer pot;
    @JsonIgnore
    protected Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public static GameStateGenerated load(String json) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(json, GameStateGenerated.class);
    }

    @JsonProperty("players")
    public List<Player> getPlayers() {
        return players;
    }

    @JsonProperty("players")
    public void setPlayers(List<Player> players) {
        this.players = Queryable.as(players);
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
    public List<Card> getCommunityCards() {
        return communityCards;
    }

    @JsonProperty("community_cards")
    public void setCommunityCards(List<Card> communityCards) {
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

    public Player getUs() {
        return this.players.first(p -> p.getName().equals("PokerGPT"));
    }

    public Status asStatus() {
        return new Status();
    }
}
