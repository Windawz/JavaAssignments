package by.gsu.pms;

import java.util.function.Consumer;

public class CompetenceParser extends Parser<Boolean> {
    public CompetenceParser(Consumer<Boolean> assigner) {
        super(MESSAGE, assigner);
    }

    private static final String MESSAGE =
        "Enter whether manager is competent: ";

    @Override
    protected ParseResult<Boolean> parse(String input) {
        boolean isCompetent =
            input.equalsIgnoreCase("true")
            || input.equalsIgnoreCase("yes")
            || input.equalsIgnoreCase("competent");

        boolean isIncompetent =
            input.equalsIgnoreCase("false")
            || input.equalsIgnoreCase("no")
            || input.equalsIgnoreCase("incompetent");

        if (isCompetent) {
            return ParseResult.valid(true);
        } else if (isIncompetent) {
            return ParseResult.valid(false);
        } else {
            return ParseResult.invalid(
                new ParseError("Invalid competence specifier"));
        }
    }
}
