package org.leanpoker.player;

import org.approvaltests.Approvals;
import org.approvaltests.core.Options;
import org.approvaltests.reporters.UseReporter;
import org.approvaltests.reporters.intellij.IntelliJReporter;
import org.junit.jupiter.api.Test;

import java.util.List;

@UseReporter(IntelliJReporter.class)
class PlayerLogicTest {

    @Test
    void verifyOurBehaviour() {
        var expected = """
                bid $40 for cards 2♣, 2♦
                """;
        GameBuilder b = startGame(4, 10, "2-clubs", "2-diamonds");
        b.fold(3);
        b.raise(4, 20);
        b.fold(1);
//        JsonJacksonApprovals.verifyAsJson(b.build());

        verifyBid(b, expected);
    }

    @Test
    void foldWhenLowChenCardsAndOpponentGoesAllIn() {
        var expected = """
                bid $0 for cards 6♠, 2♠
                """;
        GameBuilder b = startGame(2, 15, "6-spades", "2-spades");
        b.fold(1);
        b.raise(2, 20);
        b.fold(3);
        b.raise(4, 200);

        verifyBid(b, expected);
    }

    private GameBuilder startGame(int dealerPosition, int smallBlind, String card1, String card2) {
        return new GameBuilder(4)
                .weAreAt(2, card1, card2)
                .dealerIsAt(dealerPosition)
                .smallBlindIs(smallBlind);

    }

    private void verifyBid(GameBuilder builder, String expected) {
        GameState gameState = builder.build();
        int bid = PlayerLogic.gameLogic(gameState);

        String result = String.format("bid $%d for cards %s", bid, printCards(gameState.getOurHoleCards()));
        Approvals.verify(result, new Options().inline(expected));
    }

    private String printCards(List<Card> ourHoleCards) {
        return String.join(", ", ourHoleCards.stream().map(Card::toString).toList());
    }
}
