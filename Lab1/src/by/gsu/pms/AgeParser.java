package by.gsu.pms;

import java.util.function.Consumer;

public class AgeParser extends Parser<Integer> {
    public AgeParser(Consumer<Integer> assigner) {
        super(MESSAGE, assigner);
    }

    private static final String MESSAGE =
        "Enter age: ";

    @Override
    protected ParseResult<Integer> parse(String input) {
        int result = 0;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return ParseResult.invalid(
                new ParseError("Invalid number format"));
        }
        if (result < 0) {
            return ParseResult.invalid(
                new ParseError("Age may not be negative"));
        }
        return ParseResult.valid(result);
    }
}
