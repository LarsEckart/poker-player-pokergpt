package org.leanpoker.player;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

class StatusTest {

    private static String call(Integer ourIndex, Integer dealerIndex) {

        Status status = GameState.getStatus(ourIndex, dealerIndex, 4);

        String result = "";
        result += "Player 1\tPlayer 2\tPlayer 3\tPlayer 4\n";
        if (dealerIndex == 0) {
            result += "D\t\t\t\n";
        } else if (dealerIndex == 1) {
            result += "\tD\t\t\n";
        } else if (dealerIndex == 2) {
            result += "\t\tD\t\n";
        } else if (dealerIndex == 3) {
            result += "\t\t\tD\n";
        }

        return "" + status.biddingPosition();
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
}
