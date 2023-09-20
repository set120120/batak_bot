package org.example.enums;

public enum Suit {

    CLUBS(0, "CLUBS"),
    HEARTS(1, "HEARTS"),
    SPADES(2, "SPADES"),
    DIAMONDS(3, "DIAMONDS");

    private final int suitCode;

    private final String suitName;

    Suit(int suitCode, String suitName) {
        this.suitCode = suitCode;
        this.suitName = suitName;
    }

    public Suit getSuit(int suitCode) {
        return switch (suitCode) {
            case 0 -> CLUBS;
            case 1 -> HEARTS;
            case 2 -> SPADES;
            case 3 -> DIAMONDS;
            default -> throw new IllegalArgumentException("Invalid suitCode: " + suitCode);
        };
    }
    public int getSuitCode() {
        return this.suitCode;
    }

    public String getSuitName() {
        return suitName;
    }

    @Override
    public String toString() {
        return this.suitName;
    }
}