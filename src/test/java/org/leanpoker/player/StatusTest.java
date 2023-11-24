package org.leanpoker.player;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StatusTest {

    private static String call(Integer ourIndex, Integer dealerIndex) {

        Status status = GameState.getStatus(ourIndex, dealerIndex, 4, 0);

        String result = "";
        if (dealerIndex == 0) {
            result += "D|s|B|1\n";
        } else if (dealerIndex == 1) {
            result += "1|D|s|B\n";
        } else if (dealerIndex == 2) {
            result += "B|1|D|s\n";
        } else if (dealerIndex == 3) {
            result += "s|B|1|D\n";
        }

        return status.biddingPosition() + " -> " + result;
    }

    @Test
    void name() {
        Integer[] places = {0, 1, 2, 3};
        CombinationApprovals.verifyAllCombinations(
                StatusTest::call,
                places,
                places
        );
    }

    @Test
    void testIsLast() {

        assertThat(GameState.getStatus(2, 0, 4, 0).weAreLast()).isTrue();

        assertThat(GameState.getStatus(3, 0, 4, 0).weAreLast()).isFalse();
    }
}
