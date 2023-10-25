package enums;

public enum Rank {
    ACE(1, "ACE"),
    TWO(2, "TWO"),
    THREE(3, "THREE"),
    FOUR(4, "FOUR"),
    FIVE(5, "FIVE"),
    SIX(6, "SIX"),
    SEVEN(7, "SEVEN"),
    EIGHT(8, "EIGHT"),
    NINE(9, "NINE"),
    TEN(10,"TEN"),
    KNIGHT(12, "KNIGHT"),
    QUEEN(13,"QUEEN"),
    KING(14, "KING"),
    ZERO(0, "ZERO"); // temp value


    private final int value;
    private final String name;

    Rank(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
