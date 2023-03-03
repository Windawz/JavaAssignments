import by.gsu.pms.practice2.*;
import by.gsu.pms.practice2.part1.Part1CommonPlanProvider;
import by.gsu.pms.practice2.part2.Part2CommonPlanProvider;
import by.gsu.pms.practice2.part3.Part3CommonPlanProvider;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var showcaser = new Showcaser(plan ->
            plan.tryGetFee().orElse(new Money(0)).getValue() > 1000);

        List<CommonPlanProvider> providers = List.of(
            new Part1CommonPlanProvider(),
            new Part2CommonPlanProvider(),
            new Part3CommonPlanProvider());

        for (var provider : providers) {
            showcaser.run(provider);
        }
    }
}