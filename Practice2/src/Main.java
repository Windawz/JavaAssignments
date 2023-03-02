import by.gsu.pms.practice2.*;
import by.gsu.pms.practice2.part1.Part1Showcaser;
import by.gsu.pms.practice2.part2.Part2Showcaser;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<TaskShowcaser> showcasers = List.of(
            new Part1Showcaser(),
            new Part2Showcaser());
        Predicate<CommonPlan> predicate = plan ->
            plan.tryGetFee().orElse(new Money(0)).getValue() > 1000;

        for (TaskShowcaser showcaser : showcasers) {
            runShowcaser(showcaser, predicate);
        }
    }

    private static void runShowcaser(
        TaskShowcaser showcaser,
        Predicate<CommonPlan> predicate
    ) {
        String showcaserName = Text.centered(
            Text.capitalized(
                showcaser.getClass().getSimpleName()),
            24);

        System.out.printf("====%s====%n", showcaserName);
        System.out.println("--      Available Plans       --");
        showcaser.printPlans();
        System.out.println("--      Total Plan Count      --");
        showcaser.printPlanCount();
        System.out.println("--     Plans Sorted By Fee    --");
        showcaser.printSortedPlans();
        System.out.println("-- Plans Matching A Predicate --");
        showcaser.printMatchingPlans(predicate);
    }
}