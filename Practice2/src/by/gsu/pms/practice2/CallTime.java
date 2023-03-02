package by.gsu.pms.practice2;

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
}
