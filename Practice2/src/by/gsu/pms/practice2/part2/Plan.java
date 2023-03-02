package by.gsu.pms.practice2.part2;

import by.gsu.pms.practice2.CommonPlan;
import by.gsu.pms.practice2.Money;
import by.gsu.pms.practice2.Period;

import java.util.Optional;

public interface Plan extends CommonPlan {
    Money getFee();
    Period getPeriod();

    @Override
    default Optional<Money> tryGetFee() {
        return Optional.of(getFee());
    }

    @Override
    default Optional<Period> tryGetPeriod() {
        return Optional.of(getPeriod());
    }
}
