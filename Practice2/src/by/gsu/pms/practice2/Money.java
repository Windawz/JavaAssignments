package by.gsu.pms.practice2;

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
