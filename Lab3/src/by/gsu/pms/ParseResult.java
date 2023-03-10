package by.gsu.pms;

import java.util.function.Consumer;

public class ParseResult <T> {
    private ParseResult(T value) {
        if (value == null) {
            throw new NullPointerException(
                "Parse result value may not be null");
        }
        _value = value;
        _error = null;
    }

    private ParseResult(ParseError error) {
        if (error == null) {
            throw new NullPointerException(
                "Parse result error may not be null");
        }
        _value = null;
        _error = error;
    }

    private final T _value;
    private final ParseError _error;

    public static <T> ParseResult<T> valid(T value) {
        return new ParseResult<>(value);
    }

    public static <T> ParseResult<T> invalid(ParseError error) {
        return new ParseResult<>(error);
    }

    public void visit(Consumer<T> onValid, Consumer<ParseError> onError) {
        if (_value != null) {
            onValid.accept(_value);
        } else {
            onError.accept(_error);
        }
    }
}
