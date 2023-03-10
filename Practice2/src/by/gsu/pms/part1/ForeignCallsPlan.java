package by.gsu.pms.part1;

import by.gsu.pms.Period;
import by.gsu.pms.ForeignCountry;
import by.gsu.pms.Money;

import java.util.EnumSet;
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
}
