package by.gsu.pms;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        var managers = List.of(
            new Manager("Petrovsky", 23, true),
            new Manager("Grachev", 31, true),
            new Manager("Mazurov", 22, false),
            new Manager("Babkin", 29, false),
            new Manager("Trubetskoy", 30, true));
        try (var session = new Session(managers)) {
            session.run();
        }
    }
}