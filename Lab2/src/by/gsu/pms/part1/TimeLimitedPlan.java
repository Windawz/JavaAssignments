package by.gsu.pms.part1;

import by.gsu.pms.Period;
import by.gsu.pms.CallTime;
import by.gsu.pms.Money;

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
}
