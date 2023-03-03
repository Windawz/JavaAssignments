package by.gsu.pms.practice2.part3;

import by.gsu.pms.practice2.Money;
import by.gsu.pms.practice2.Period;
import by.gsu.pms.practice2.Traffic;

import java.util.Optional;

public class WebPlan implements Plan {
    public WebPlan(Money fee, Period period, Traffic traffic) {
        _simplePlan = new SimplePlan(fee, period);
        _traffic = traffic;
    }

    private final SimplePlan _simplePlan;
    private final Traffic _traffic;

    @Override
    public Optional<Traffic> tryGetTraffic() {
        return Optional.of(getTraffic());
    }

    @Override
    public Money getFee() {
        return _simplePlan.getFee();
    }

    @Override
    public Period getPeriod() {
        return _simplePlan.getPeriod();
    }

    public Traffic getTraffic() {
        return _traffic;
    }
}
