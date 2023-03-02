package by.gsu.pms.practice2;

import java.util.function.Predicate;

public interface TaskShowcaser {
    void printPlans();
    void printPlanCount();
    void printSortedPlans();
    void printMatchingPlans(Predicate<CommonPlan> predicate);
}
