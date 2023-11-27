package org.leanpoker.player;

import org.lambda.query.Queryable;
import org.lambda.utils.Range;

import java.util.Arrays;


class GameBuilder {

    private final GameState gameState;
    private int nextPlayerId = 1;

    public GameBuilder(int numberOfPlayers) {
        gameState = new GameState();
        gameState.setInAction(0);
        Queryable<Player> players = Queryable.as(Range.get(1, numberOfPlayers)).select(i -> new Player("Player " + i));
        gameState.setPlayers(players);
    }

    public GameBuilder weAreAt(int position, String... cards) {
        Player player = gameState.getPlayers().get(position - 1);
        player.setName("PokerGPT");
        player.setHoleCards(Arrays.stream(cards).map(s -> s.split("-")).map(a -> new Card(a[0], a[1])).toList());
        gameState.setInAction(position - 1);
        return this;
    }

    public GameBuilder dealerIsAt(int position) {
        gameState.setDealer(position - 1);
        return this;
    }

    public GameBuilder smallBlindIs(int amount) {
        gameState.setSmallBlind(amount);
        gameState.setBigBlind(2 * amount);
        gameState.setCurrentBuyIn(2 * amount);
        gameState.setMinimumRaise(amount);
        int smallBlindIndex = this.gameState.getDealer() + 1;
        gameState.getPlayerAt(smallBlindIndex).setBet(amount);
        gameState.getPlayerAt(smallBlindIndex + 1).setBet(amount * 2);
        gameState.setPot(amount * 3);
        return this;
    }

    public GameBuilder addAction(int playerPosition, int amount) {
        if (amount < 0) {
            this.gameState.getPlayerAt(playerPosition - 1).setStatus("folded");
        } else {
            this.gameState.getPlayerAt(playerPosition - 1).increaseBet(amount);
            this.gameState.setPot(this.gameState.getPot() + amount);
        }

        return this;
    }

    public GameState build() {
        return gameState;
    }
}
