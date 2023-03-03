package by.gsu.pms.practice2.part3;

import by.gsu.pms.practice2.CallTime;
import by.gsu.pms.practice2.Money;
import by.gsu.pms.practice2.Period;

import java.util.Optional;

public abstract class TimeLimitedPlan implements Plan {
    public TimeLimitedPlan(Money fee, Period period, CallTime callTime) {
        _simplePlan = new SimplePlan(fee, period);
        _callTime = callTime;
    }

    private final SimplePlan _simplePlan;
    private final CallTime _callTime;

    @Override
    public Optional<CallTime> tryGetCallTime() {
        return Optional.of(getCallTime());
    }

    @Override
    public Money getFee() {
        return _simplePlan.getFee();
    }

    @Override
    public Period getPeriod() {
        return _simplePlan.getPeriod();
    }

    public CallTime getCallTime() {
        return _callTime;
    }
}
