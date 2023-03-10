package by.gsu.pms;

import java.util.function.Consumer;

public class SurnameParser extends Parser<String> {
    public SurnameParser(Consumer<String> assigner) {
        super(MESSAGE, assigner);
    }

    private static final String MESSAGE =
        "Enter surname: ";

    @Override
    protected ParseResult<String> parse(String input) {
        boolean hasInvalidCharacters = input
            .codePoints()
            .anyMatch(cp -> !Character.isLetter(cp));

        if (hasInvalidCharacters) {
            return ParseResult.invalid(
                new ParseError("Surname contains invalid characters"));
        }

        return ParseResult.valid(Text.capitalized(input));
    }
}
