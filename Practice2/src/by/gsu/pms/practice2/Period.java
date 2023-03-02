package by.gsu.pms.practice2;

public class Period {
    public Period(int dayCount) {
        if (dayCount < 0) {
            throw new IllegalArgumentException(
                "Day count may not be negative");
        }
        _dayCount = dayCount;
    }

    private final int _dayCount;

    public int getDays() {
        return _dayCount;
    }
}
