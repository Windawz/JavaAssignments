package by.gsu.pms.practice2;

public class Text {
    private Text() {
    }

    public static String capitalized(String value) {
        var context = new Object() {
            final StringBuilder builder = new StringBuilder(value.length());
            int lastCp = -1;
        };

        value.codePoints().forEach(cp -> {
            boolean shouldSplit = false;
            if (context.lastCp != -1) {
                if (Character.isUpperCase(cp)) {
                    shouldSplit = true;
                } else if (Character.isDigit(cp)) {
                    if (!Character.isDigit(context.lastCp)) {
                        shouldSplit = true;
                    }
                }
            }

            if (shouldSplit) {
                context.builder.append(' ');
            }

            context.builder.appendCodePoint(cp);
            context.lastCp = cp;
        });

        return context.builder.toString();
    }

    public static String centered(String value, int minWidth) {
        if (minWidth < 0) {
            throw new IllegalArgumentException(
                "Minimal width may not be negative");
        }

        int cpCount = value.codePointCount(0, value.length());
        int whiteSpaceCountPerHalf = cpCount / 4;
        StringBuilder builder = new StringBuilder(cpCount);
        for (int i = 0; i < whiteSpaceCountPerHalf; i++) {
            builder.append(' ');
        }
        builder.append(value);
        for (int i = 0; i < whiteSpaceCountPerHalf; i++) {
            builder.append(' ');
        }
        return builder.toString();
    }
}
