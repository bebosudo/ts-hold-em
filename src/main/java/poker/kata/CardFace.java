package poker.kata;

public enum CardFace {
    // We are constructing these objects with a certain value, and we're passing the value to the constructor below.
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    JACK(11), QUEEN(12), KING(13), ACE(14);

    private final int value;

    CardFace(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
