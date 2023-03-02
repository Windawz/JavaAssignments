package by.gsu.pms;

public class Money {
    public Money(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(
                "Money value may not be negative");
        }
        _value = value;
    }

    private final int _value;

    public int getValue() {
        return _value;
    }
}
