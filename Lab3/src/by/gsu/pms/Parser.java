package by.gsu.pms;

import java.util.Optional;
import java.util.function.Consumer;

public abstract class Parser <T> {
    public Parser(String message, Consumer<T> assigner) {
        _message = message;
        _assigner = assigner;
    }

    private final String _message;
    private final Consumer<T> _assigner;

    public final String getMessage() {
        return _message;
    }

    public final Optional<ParseError> parseAndAssign(String input) {
        input = input.strip();
        var result = parse(input);
        var lambdaContext = new Object() {
            ParseError error = null;
        };
        result.visit(
            v -> _assigner.accept(v),
            e -> lambdaContext.error = e
        );
        return Optional.ofNullable(lambdaContext.error);
    }

    protected abstract ParseResult<T> parse(String input);
}
