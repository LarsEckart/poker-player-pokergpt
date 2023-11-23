package org.leanpoker.player;

class Status {

    private int ourPlace;
    private int dealerPlace;
    private boolean haveOtherPlayersBid;

    public Status() {
    }

    public Status(int place, boolean haveOtherPlayersBid) {
        this.ourPlace = place;
        this.haveOtherPlayersBid = haveOtherPlayersBid;
    }

    public int getOurPlace() {
        return ourPlace;
    }

    public boolean isHaveOtherPlayersBid() {
        return haveOtherPlayersBid;
    }

    public int getDealerPlace() {
        return dealerPlace;
    }

    public int getNumberOfBidsBeforeUs() {
        return ourPlace - dealerPlace;
    }
}
