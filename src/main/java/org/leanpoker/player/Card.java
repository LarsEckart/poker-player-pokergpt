package org.leanpoker.player;

record Card(String rank, String suit) {

    public int asNumber() {
        return switch (rank) {
            case "A" -> 14;
            case "K" -> 13;
            case "Q" -> 12;
            case "J" -> 11;
            default -> Integer.parseInt(rank);
        };
    }
}
