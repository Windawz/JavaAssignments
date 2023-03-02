package by.gsu.pms.practice2.part2;

import by.gsu.pms.practice2.*;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public class Part2Showcaser implements TaskShowcaser {
    public Part2Showcaser() {
        _plans = List.of(
            new SimplePlan(new Money(1000), new Period(30)),
            new SimplePlan(new Money(500), new Period(15)),
            new WebPlan(new Money(1200), new Period(30), new Traffic(4096)),
            new WebPlan(new Money(2000), new Period(30), Traffic.UNLIMITED),
            new TimeLimitedPlan(new Money(500), new Period(15), new CallTime(180)),
            new ForeignCallsPlan(new Money(1500), new Period(30),
                EnumSet.of(ForeignCountry.COUNTRY1, ForeignCountry.COUNTRY3)));
    }

    private final List<Plan> _plans;

    @Override
    public void printPlans() {
        _plans.forEach(System.out::println);
    }

    @Override
    public void printPlanCount() {
        System.out.println(_plans.size());
    }

    @Override
    public void printSortedPlans() {
        _plans.stream()
            .sorted(Comparator.comparingInt(
                plan -> plan.getFee().getValue()))
            .forEach(System.out::println);
    }

    @Override
    public void printMatchingPlans(Predicate<CommonPlan> predicate) {
        _plans.stream()
            .filter(predicate)
            .forEach(System.out::println);
    }
}
