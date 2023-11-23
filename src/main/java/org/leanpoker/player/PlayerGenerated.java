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
public class PlayerGenerated {

    @JsonProperty("name")
    protected String name;
    @JsonProperty("stack")
    protected Integer stack;
    @JsonProperty("status")
    protected String status;
    @JsonProperty("bet")
    protected Integer bet;
    @JsonProperty("hole_cards")
    protected List<Card> holeCards;
    @JsonProperty("version")
    protected String version;
    @JsonProperty("id")
    protected Integer id;
    @JsonIgnore
    protected Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public PlayerGenerated() {
    }

    public PlayerGenerated(String name, int i, String active, int i1, List<Card> cards, String s, int i2) {

    }

    public PlayerGenerated(Card... cards) {
        this.name = "PokerGPT";
        this.holeCards = List.of(cards);
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("stack")
    public Integer getStack() {
        return stack;
    }

    @JsonProperty("stack")
    public void setStack(Integer stack) {
        this.stack = stack;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("bet")
    public Integer getBet() {
        return bet;
    }

    @JsonProperty("bet")
    public void setBet(Integer bet) {
        this.bet = bet;
    }

    @JsonProperty("hole_cards")
    public List<Card> getHoleCards() {
        return holeCards;
    }

    @JsonProperty("hole_cards")
    public void setHoleCards(List<Card> holeCards) {
        this.holeCards = holeCards;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
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
