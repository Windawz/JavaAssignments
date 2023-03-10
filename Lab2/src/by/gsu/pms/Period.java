package by.gsu.pms;

import java.text.MessageFormat;

public class Period {
    public Period(int dayCount) {
        if (dayCount < 0) {
            throw new IllegalArgumentException(
                "Day count may not be negative");
        }
        _dayCount = dayCount;
    }

    private final int _dayCount;

    public int getDayCount() {
        return _dayCount;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} days", getDayCount());
    }
}
