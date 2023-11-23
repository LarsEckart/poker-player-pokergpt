package org.leanpoker.player;

/*

    Score your highest card only. Do not add any points for your lower card.
        A = 10 points.
        K = 8 points.
        Q = 7 points.
        J = 6 points.
        10 to 2 = 1/2 of card value. (e.g. a 6 would be worth 3 points)
    Multiply pairs by 2 of one card’s value. However, minimum score for a pair is 5.
        (e.g. KK = 16 points, 77 = 7 points, 22 = 5 points)
    Add 2 points if cards are suited.
    Subtract points if their is a gap between the two cards.
        No gap = -0 points.
        1 card gap = -1 points.
        2 card gap = -2 points.
        3 card gap = -4 points.
        4 card gap or more = -5 points. (Aces are high this step, so hands like A2, A3 etc. have a 4+ gap.)
    Add 1 point if there is a 0 or 1 card gap and both cards are lower than a Q. (e.g. JT, 75, 32 etc, this bonus point does not apply to pocket pairs)
    Round half point scores up. (e.g. 7.5 rounds up to 8)

 */
class ChenFormula {

    public static double calculate(Card card1, Card card2) {
        double score1 = card1.asNumber();
        double score2 = card2.asNumber();

        double score = Math.max(score1, score2);

        if (card1.equals(card2)) {
            score *= 2;
        }

        if (card1.suit().equals(card2.suit())) {
            score += 2;
        }

        int gap = Math.abs(card1.asNumber() - card2.asNumber());
        if (gap == 0) {
            score += 1;
        } else if (gap == 1) {
            score += 0;
        } else if (gap == 2) {
            score -= 1;
        } else if (gap == 3) {
            score -= 2;
        } else if (gap == 4) {
            score -= 4;
        } else {
            score -= 5;
        }

        if (score < 5) {
            score = 5;
        }

        return Math.ceil(score);
    }
}
