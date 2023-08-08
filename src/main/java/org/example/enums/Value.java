package org.example.enums;

public enum Value {
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(11, "JACK"),
    QUEEN(12, "QUEEN"),
    KING(13, "KING"),
    ACE(14, "ACE");

    private final int valueCode;
    private final String valueName;

    Value(int valueCode, String valueName) {
        this.valueCode = valueCode;
        this.valueName = valueName;
    }

    public int getValueCode() {
        return this.valueCode;
    }

    @Override
    public String toString() {
        return this.valueName;
    }


}
