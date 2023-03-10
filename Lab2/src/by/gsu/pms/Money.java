package by.gsu.pms;

import java.text.MessageFormat;

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

    @Override
    public String toString() {
        return MessageFormat.format("¤{0}", getValue());
    }
}
