package by.gsu.pms.practice2.part1;

import by.gsu.pms.practice2.CallTime;
import by.gsu.pms.practice2.Money;
import by.gsu.pms.practice2.Period;

public class TimeLimitedPlan extends Plan {
    public TimeLimitedPlan(Money fee, Period period, CallTime callTime) {
        super(fee, period);
        _callTime = callTime;
    }

    private final CallTime _callTime;

    public CallTime getCallTime() {
        return _callTime;
    }
}
