package by.gsu.pms;

import java.util.Optional;
import java.util.Scanner;

public class Manager {
    public Manager(String surname, int age, boolean isCompetent) {
        _surname = surname;
        _age = age;
        _isCompetent = isCompetent;
    }

    private final String _surname;
    private final int _age;
    private final boolean _isCompetent;

    public static Manager scan(Scanner scanner) {
        var lambdaContext = new Object() {
            String surname;
            int age;
            boolean isCompetent;
        };

        var parsers = new Parser<?>[] {
            new SurnameParser(
                value -> lambdaContext.surname = value),
            new AgeParser(
                value -> lambdaContext.age = value),
            new CompetenceParser(
                value -> lambdaContext.isCompetent = value),
        };

        for (var parser : parsers) {
            String message = parser.getMessage();
            Optional<ParseError> maybeError = Optional.empty();
            do {
                System.out.println(parser.getMessage());
                String input = scanner.nextLine();
                maybeError = parser.parseAndAssign(input);
                if (maybeError.isPresent()) {
                    System.out.println("Invalid value. Try again.");
                }
            } while (maybeError.isPresent());
        }

        return new Manager(
            lambdaContext.surname,
            lambdaContext.age,
            lambdaContext.isCompetent);
    }

    public String getSurname() {
        return _surname;
    }

    public int getAge() {
        return _age;
    }

    public boolean isCompetent() {
        return _isCompetent;
    }
}
