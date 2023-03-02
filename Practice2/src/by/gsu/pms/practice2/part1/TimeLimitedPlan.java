package by.gsu.pms.practice2.part1;

import by.gsu.pms.practice2.CallTime;
import by.gsu.pms.practice2.Money;
import by.gsu.pms.practice2.Period;

import java.text.MessageFormat;
import java.util.Optional;

public class TimeLimitedPlan extends Plan {
    public TimeLimitedPlan(Money fee, Period period, CallTime callTime) {
        super(fee, period);
        _callTime = callTime;
    }

    private final CallTime _callTime;

    public CallTime getCallTime() {
        return _callTime;
    }

    @Override
    public Optional<CallTime> tryGetCallTime() {
        return Optional.of(getCallTime());
    }

    @Override
    public String toString() {
        return super.toString()
            + MessageFormat.format(" Call Time: {0};", getCallTime());
    }
}
