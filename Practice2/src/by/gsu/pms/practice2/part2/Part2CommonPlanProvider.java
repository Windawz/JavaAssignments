package by.gsu.pms.practice2.part2;

import by.gsu.pms.practice2.*;

import java.util.EnumSet;
import java.util.List;

public class Part2CommonPlanProvider implements CommonPlanProvider {
    @Override
    public String getPartName() {
        return "Part 2";
    }

    @Override
    public List<CommonPlan> getCommonPlans() {
        return List.of(
            new SimplePlan(new Money(1000), new Period(30)),
            new SimplePlan(new Money(500), new Period(15)),
            new WebPlan(new Money(1200), new Period(30), new Traffic(4096)),
            new WebPlan(new Money(2000), new Period(30), Traffic.UNLIMITED),
            new TimeLimitedPlan(new Money(500), new Period(15), new CallTime(180)),
            new ForeignCallsPlan(new Money(1500), new Period(30),
                EnumSet.of(ForeignCountry.COUNTRY1, ForeignCountry.COUNTRY3)));
    }
}
