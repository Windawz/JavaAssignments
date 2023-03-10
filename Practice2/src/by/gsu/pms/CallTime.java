package by.gsu.pms;

import java.text.MessageFormat;

public class CallTime {
    public CallTime(int minuteCount) {
        if (minuteCount < 0) {
            throw new IllegalArgumentException(
                "Minute count may not be negative");
        }
        _minuteCount = minuteCount;
    }

    private final int _minuteCount;

    public int getMinuteCount() {
        return _minuteCount;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}m", getMinuteCount());
    }
}
