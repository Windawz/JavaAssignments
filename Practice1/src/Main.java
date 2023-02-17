import by.gsu.pms.ExpenseStat;

import java.util.*;
import java.util.Set;

public class Main {
    private static final String[] ACCOUNT_NAMES = {
        "Kevin Parcel",
        "David Pratt",
        "Bertram Reynolds",
        "Julian Rice",
        "Claire Richard",
        "Jonathan Snellgrove",
        "David Warner",
        "Antony Wilkinson",
        "Amy Williams",
        "Andrew Wood",
        "Simon Wood",
        "Jeremy Wright",
    };

    public static void main(String[] args) {
        var stats = makeRandomStats(7);

        for (var stat : stats) {
            if (stat != null) {
                stat.show();
                System.out.println();
            }
        }

        stats[stats.length - 1].setTransportationExpenses(666);

        System.out.println("Duration = " + (stats[0].getDayCount() + stats[1].getDayCount()));
        System.out.println();

        for (var stat : stats) {
            if (stat != null) {
                System.out.println(stat.toString());
            }
        }
        System.out.println();

        var totalExpensesSum = getTotalExpensesSum(stats);
        System.out.println("Total expenses sum = " + totalExpensesSum);
        System.out.println();

        var maxTotalExpensesAccountName = getMaxTotalExpensesAccountName(stats);
        System.out.println("Account with greatest total expenses: " + maxTotalExpensesAccountName);
        System.out.println();
    }

    private static String getMaxTotalExpensesAccountName(ExpenseStat[] stats) {
        return Arrays.stream(stats)
            .filter(Objects::nonNull)
            .max(Comparator.comparingInt(ExpenseStat::getTotal))
            .get()
            .getAccountName();
    }

    private static int getTotalExpensesSum(ExpenseStat[] stats) {
        return Arrays.stream(stats)
            .filter(Objects::nonNull)
            .map(ExpenseStat::getTotal)
            .reduce(Integer::sum)
            .get();
    }

    private static ExpenseStat[] makeRandomStats(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count may not be negative");
        }

        var usedNames = new HashSet<String>(ACCOUNT_NAMES.length);
        var random = new Random(makeSeedFromCurrentTime());
        var stats = new ExpenseStat[count];

        for (int i = 0; i < stats.length; i++) {
            if (i == 2) {
                stats[i] = null;
            } else if (i == stats.length - 1) {
                stats[i] = new ExpenseStat();
            } else {
                stats[i] = makeRandomStat(random, usedNames);
            }
        }

        return stats;
    }

    private static ExpenseStat makeRandomStat(Random random, Set<String> usedNames) {
        return new ExpenseStat(
            random.nextInt(10, 200),
            pickRandomName(random, usedNames),
            random.nextInt(400, 1000),
            random.nextInt(2, 20)
        );
    }

    private static String pickRandomName(Random random, Set<String> usedNames) {
        if (usedNames.size() < ACCOUNT_NAMES.length) {
            String name = null;
            do {
                name = ACCOUNT_NAMES[random.nextInt(0, ACCOUNT_NAMES.length)];
            } while (usedNames.contains(name));
            usedNames.add(name);
            return name;
        } else {
            throw new IllegalStateException("All names have been used up");
        }
    }

    private static long makeSeedFromCurrentTime() {
        return System.currentTimeMillis();
    }
}