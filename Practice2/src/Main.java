import by.gsu.pms.practice2.CommonPlan;
import by.gsu.pms.practice2.TaskShowcaser;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<TaskShowcaser> showcasers = List.of();
        List<Predicate<CommonPlan>> predicates = List.of();

        for (int i = 0; i < Math.min(showcasers.size(), predicates.size()); i++) {
            runShowcaser(showcasers.get(i), predicates.get(i));
        }
    }

    private static void runShowcaser(TaskShowcaser showcaser, Predicate<CommonPlan> predicate) {
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