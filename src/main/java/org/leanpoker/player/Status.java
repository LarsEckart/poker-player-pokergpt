package org.leanpoker.player;

record Status(int biddingPosition, int totalPlayers, int howManyHaveBid){

    public boolean weAreLast() {
        return biddingPosition == totalPlayers;
    }
}
