package by.gsu.pms.practice2.part2;

import by.gsu.pms.practice2.*;

import java.text.MessageFormat;
import java.util.EnumSet;
import java.util.Optional;

public class TimeLimitedPlan implements Plan {
    public TimeLimitedPlan(Money fee, Period period, CallTime callTime) {
        _simplePlan = new SimplePlan(fee, period);
        _callTime = callTime;
    }

    private final SimplePlan _simplePlan;
    private final CallTime _callTime;

    @Override
    public Optional<Traffic> tryGetTraffic() {
        return Optional.empty();
    }

    @Override
    public Optional<CallTime> tryGetCallTime() {
        return Optional.of(getCallTime());
    }

    @Override
    public Optional<EnumSet<ForeignCountry>> tryGetForeignCountries() {
        return Optional.empty();
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
