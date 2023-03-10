package by.gsu.pms;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Showcaser {
    public Showcaser(Predicate<CommonPlan> predicate) {
        _predicate = predicate;
    }

    private final Predicate<CommonPlan> _predicate;

    public void run(CommonPlanProvider provider) {
        List<CommonPlan> plans = provider.getCommonPlans();

        String title = Text.centered(
            Text.capitalized(provider.getPartName()), 24);

        System.out.printf("====%s====%n", title);
        System.out.println("--      Available Plans       --");
        printPlans(plans);
        System.out.println("--      Total Plan Count      --");
        printPlanCount(plans);
        System.out.println("--     Plans Sorted By Fee    --");
        printSortedPlans(plans);
        System.out.println("-- Plans Matching A Predicate --");
        printMatchingPlans(plans);
    }

    private void printPlans(List<CommonPlan> plans) {
        plans.stream()
            .map(CommonPlan::getInfoString)
            .forEach(System.out::println);
    }

    private void printPlanCount(List<CommonPlan> plans) {
        System.out.println(plans.size());
    }

    private void printSortedPlans(List<CommonPlan> plans) {
        plans.stream()
            .sorted(Comparator.comparingInt(plan ->
                plan.tryGetFee()
                    .orElse(new Money(0)).getValue()))
            .map(CommonPlan::getInfoString)
            .forEach(System.out::println);
    }

    private void printMatchingPlans(List<CommonPlan> plans) {
        plans.stream()
            .filter(_predicate)
            .map(CommonPlan::getInfoString)
            .forEach(System.out::println);
    }
}
