package by.gsu.pms;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;

public class Session implements AutoCloseable {
    public Session(
        String managerFileName
    ) throws IOException, ClassNotFoundException {
        _managerFileName = managerFileName;
        deserializeManagers(_managerFileName);
    }

    private final String _managerFileName;
    private final ArrayList<Manager> _managers = new ArrayList<>();
    private boolean _closed = false;

    public void run() {

    }

    @Override
    public void close() throws IOException {
        if (!_closed) {
            _closed = true;
        }
    }

    private void printManagers() {
        for (var manager : _managers) {
            System.out.println(
                MessageFormat.format(
                    "Manager {0} is {1} years old and is {2}",
                    manager.getSurname(),
                    manager.getAge(),
                    manager.isCompetent() ? "competent" : "incompetent"));
        }
    }

    private void throwIfClosed() {
        if (_closed) {
            throw new IllegalStateException("Session has been closed");
        }
    }

    private static Optional<Manager> scanManager(
        Scanner scanner,
        Function<String, Boolean> stopHandler
    ) {
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

        boolean stopped = false;
        for (var parser : parsers) {
            String message = parser.getMessage();
            Optional<ParseError> maybeError = Optional.empty();
            do {
                System.out.println(parser.getMessage());
                String input = scanner.nextLine();
                stopped = stopHandler.apply(input);
                if (stopped) {
                    break;
                }
                maybeError = parser.parseAndAssign(input);
                if (maybeError.isPresent()) {
                    System.out.println("Invalid value. Try again.");
                }
            } while (maybeError.isPresent());
            if (stopped) {
                break;
            }
        }
        if (stopped) {
            return Optional.empty();
        } else {
            return Optional.of(
                new Manager(
                    lambdaContext.surname,
                    lambdaContext.age,
                    lambdaContext.isCompetent));
        }
    }
}
