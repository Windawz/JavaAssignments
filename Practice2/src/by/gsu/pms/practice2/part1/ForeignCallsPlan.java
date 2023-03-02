package by.gsu.pms.practice2.part1;

import by.gsu.pms.practice2.ForeignCountry;
import by.gsu.pms.practice2.Money;
import by.gsu.pms.practice2.Period;

import java.util.EnumSet;

public class ForeignCallsPlan extends Plan {
    public ForeignCallsPlan(Money fee, Period period, EnumSet<ForeignCountry> foreignCountries) {
        super(fee, period);
        _foreignCountries = EnumSet.copyOf(foreignCountries);
    }

    private EnumSet<ForeignCountry> _foreignCountries;

    public EnumSet<ForeignCountry> getForeignCountries() {
        return EnumSet.copyOf(_foreignCountries);
    }
}
