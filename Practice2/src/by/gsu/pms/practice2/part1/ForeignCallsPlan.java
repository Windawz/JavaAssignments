package by.gsu.pms.practice2.part1;

import by.gsu.pms.practice2.ForeignCountry;
import by.gsu.pms.practice2.Money;
import by.gsu.pms.practice2.Period;

import java.text.MessageFormat;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

public class ForeignCallsPlan extends Plan {
    public ForeignCallsPlan(Money fee, Period period, EnumSet<ForeignCountry> foreignCountries) {
        super(fee, period);
        _foreignCountries = EnumSet.copyOf(foreignCountries);
    }

    private EnumSet<ForeignCountry> _foreignCountries;

    public EnumSet<ForeignCountry> getForeignCountries() {
        return EnumSet.copyOf(_foreignCountries);
    }

    @Override
    public Optional<EnumSet<ForeignCountry>> tryGetForeignCountries() {
        return Optional.of(getForeignCountries());
    }

    @Override
    public String toString() {
        List<String> countryNameList = getForeignCountries()
            .stream()
            .map(country -> country.toString())
            .toList();
        return super.toString()
            + MessageFormat.format(" Foreign Countries: {0};", String.join(", ", countryNameList));
    }
}
