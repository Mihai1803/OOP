package enums;

public enum Suit {
    CLUBS(1, "CLUBS"),
    DIAMONDS(2, "DIAMONDS"),
    HEARTS(3, "HEARTS"),
    SPADES(4, "SPADES");

    private final int value;
    private final String name;

    Suit(int value, String name) {
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
