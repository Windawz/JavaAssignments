package by.gsu.pms.part1;

import by.gsu.pms.Period;
import by.gsu.pms.Money;
import by.gsu.pms.Traffic;

import java.util.Optional;

public class WebPlan extends Plan {
    public WebPlan(Money fee, Period period, Traffic traffic) {
        super(fee, period);
        _traffic = traffic;
    }

    private final Traffic _traffic;

    public Traffic getTraffic() {
        return _traffic;
    }

    @Override
    public Optional<Traffic> tryGetTraffic() {
        return Optional.of(getTraffic());
    }
}
