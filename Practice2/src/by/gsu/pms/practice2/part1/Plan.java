package by.gsu.pms.practice2.part1;

import by.gsu.pms.practice2.*;

import java.text.MessageFormat;
import java.util.EnumSet;
import java.util.Optional;

public class Plan implements CommonPlan {
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

    @Override
    public Optional<Money> tryGetFee() {
        return Optional.of(getFee());
    }

    @Override
    public Optional<Period> tryGetPeriod() {
        return Optional.of(getPeriod());
    }
}
