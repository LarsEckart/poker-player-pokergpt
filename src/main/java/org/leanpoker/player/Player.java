package org.leanpoker.player;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Player extends PlayerGenerated {

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public Player(Card... cards) {
        this.name = "PokerGPT";
        this.holeCards = List.of(cards);
    }


}
