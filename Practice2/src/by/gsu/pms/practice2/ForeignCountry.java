package by.gsu.pms.practice2;

public enum ForeignCountry {
    COUNTRY1,
    COUNTRY2,
    COUNTRY3,
    COUNTRY4,
    ;


    @Override
    public String toString() {
        return switch (this) {
            case COUNTRY1 -> "Country 1";
            case COUNTRY2 -> "Country 2";
            case COUNTRY3 -> "Country 3";
            case COUNTRY4 -> "Country 4";
        };
    }
}
