package by.gsu.pms.practice2;

public class Traffic {
    public Traffic(int megabyteCount) {
        if (megabyteCount < 0) {
            throw new IllegalArgumentException(
                "Megabyte count may not be negative");
        }
        _megabyteCount = megabyteCount;
    }

    private Traffic() {
        _megabyteCount = -1;
    }

    public static final Traffic UNLIMITED = new Traffic();
    private final int _megabyteCount;

    public boolean isUnlimited() {
        return _megabyteCount == -1;
    }

    public int getMegabyteCount() {
        return _megabyteCount;
    }
}
