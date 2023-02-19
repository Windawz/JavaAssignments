import by.gsu.pms.ExpenseStat;

import java.util.*;
import java.util.function.Predicate;

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

        System.out.println("Setting transportation expenses on the last item...");
        stats[stats.length - 1].setTransportationExpenses(666);
        System.out.println();

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
            .filter(stat -> stat != null)
            .max(Comparator.comparingInt(stat -> stat.getTotal()))
            .get()
            .getAccountName();
    }

    private static int getTotalExpensesSum(ExpenseStat[] stats) {
        return Arrays.stream(stats)
            .filter(stat -> stat != null)
            .map(stat -> stat.getTotal())
            .reduce((acc, value) -> acc + value)
            .get();
    }

    private static ExpenseStat[] makeRandomStats(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count may not be negative");
        }

        var random = makeRandom();

        var rates = getRandomInts(random, 100, 2000);
        var accountNames = getRandomNames(random, ACCOUNT_NAMES);
        var expenses = getRandomInts(random, 0, 2000);
        var dayCounts = getRandomInts(random, 2, 31);

        var stats = new ExpenseStat[count];
        for (int i = 0; i < stats.length; i++) {
            if (i == 2) {
                stats[i] = null;
            } else if (i == stats.length - 1) {
                stats[i] = new ExpenseStat();
            } else {
                stats[i] = new ExpenseStat(
                    rates.get(i),
                    accountNames.get(i),
                    expenses.get(i),
                    dayCounts.get(i));
            }
        }

        return stats;
    }

    private static List<Integer> getRandomInts(Random random, int origin, int bound) {
        if (origin >= bound) {
            throw new IllegalArgumentException("Origin may not be greater than or equal to bound");
        }
        var count = bound - origin;
        var list = new ArrayList<Integer>(count);
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(origin, bound));
        }
        return list;
    }

    private static List<String> getRandomNames(Random random, String[] names) {
        return getShuffledList(random, Arrays.asList(names));
    }

    private static <T> List<T> getShuffledList(Random random, List<T> list) {
        int count = list.size();
        var shuffledIndices = new ArrayList<Integer>(count);
        for (int i = 0; i < count; i++) {
            int shuffledIndex = getRandomIntUntil(random, 0, count, x -> !shuffledIndices.contains(x));
            shuffledIndices.add(shuffledIndex);
        }
        var shuffledItemsList = new ArrayList<>(List.copyOf(list));
        for (int i = 0; i < count; i++) {
            shuffledItemsList.set(i, list.get(shuffledIndices.get(i)));
        }
        return shuffledItemsList;
    }

    private static int getRandomIntUntil(Random random, int origin, int bound, Predicate<Integer> condition) {
        if (origin >= bound) {
            throw new IllegalArgumentException("Origin may not be greater than or equal to bound");
        }
        int i;
        do {
            i = random.nextInt(origin, bound);
        } while (!condition.test(i));
        return i;
    }

    private static Random makeRandom() {
        return new Random(makeSeedFromCurrentTime());
    }

    private static long makeSeedFromCurrentTime() {
        return System.currentTimeMillis();
    }
}