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

        var sum = Arrays.stream(stats)
            .filter(Objects::nonNull)
            .map(stat -> stat.getTotal())
            .reduce((acc, item) -> acc + item)
            .get();
        System.out.println("Total expenses sum = " + sum);
        System.out.println();

        var maxTotalExpensesAccountName = Arrays.stream(stats)
            .filter(Objects::nonNull)
            .max(Comparator.comparingInt(ExpenseStat::getTotal))
            .get()
            .getAccountName();
        System.out.println("Account with greatest total expenses: " + maxTotalExpensesAccountName);
        System.out.println();
    }

    private static ExpenseStat[] makeRandomStats(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count may not be negative");
        }
        var namePool = new HashSet<String>(ACCOUNT_NAMES.length);
        var random = new Random(makeSeedFromCurrentTime());
        var stats = new ExpenseStat[count];
        for (int i = 0; i < stats.length; i++) {
            if (i == 2) {
                stats[i] = null;
            } else if (i == stats.length - 1) {
                stats[i] = new ExpenseStat();
            } else {
                stats[i] = makeRandomStat(random, namePool);
            }
        }
        return stats;
    }

    private static ExpenseStat makeRandomStat(Random random, Set<String> namePool) {
        String name = null;
        if (namePool.size() < ACCOUNT_NAMES.length) {
            do {
                name = ACCOUNT_NAMES[random.nextInt(0, ACCOUNT_NAMES.length)];
            } while (namePool.contains(name));
            namePool.add(name);
        }

        return new ExpenseStat(
            random.nextInt(10, 200),
            name,
            random.nextInt(400, 1000),
            random.nextInt(2, 20)
        );
    }

    private static long makeSeedFromCurrentTime() {
        return System.currentTimeMillis();
    }
}