package by.gsu.pms.part2;

import by.gsu.pms.ForeignCountry;
import by.gsu.pms.Money;
import by.gsu.pms.Period;

import java.util.EnumSet;
import java.util.Optional;

public class ForeignCallsPlan implements Plan {
    public ForeignCallsPlan(
        Money fee,
        Period period,
        EnumSet<ForeignCountry> foreignCountries
    ) {
        _simplePlan = new SimplePlan(fee, period);
        _foreignCountries = EnumSet.copyOf(foreignCountries);
    }

    private final SimplePlan _simplePlan;
    private final EnumSet<ForeignCountry> _foreignCountries;

    @Override
    public Optional<EnumSet<ForeignCountry>> tryGetForeignCountries() {
        return Optional.of(getForeignCountries());
    }

    @Override
    public Money getFee() {
        return _simplePlan.getFee();
    }

    @Override
    public Period getPeriod() {
        return _simplePlan.getPeriod();
    }

    public EnumSet<ForeignCountry> getForeignCountries() {
        return EnumSet.copyOf(_foreignCountries);
    }
}
