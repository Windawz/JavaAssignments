package by.gsu.pms.practice2.part2;

import by.gsu.pms.practice2.*;

import java.text.MessageFormat;
import java.util.EnumSet;
import java.util.Optional;

public class SimplePlan implements Plan {
    public SimplePlan(Money fee, Period period) {
        _fee = fee;
        _period = period;
    }

    private final Money _fee;
    private final Period _period;

    @Override
    public Money getFee() {
        return _fee;
    }

    @Override
    public Period getPeriod() {
        return _period;
    }
}
