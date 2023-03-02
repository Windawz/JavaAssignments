package by.gsu.pms.practice2.part1;

import by.gsu.pms.practice2.*;

public class Plan {
    public Plan(Money fee, Period period) {
        _fee = fee;
        _period = period;
    }

    private final Money _fee;
    private final Period _period;

    public Money getFee() {
        return _fee;
    }

    public Period getPeriod() {
        return _period;
    }
}
