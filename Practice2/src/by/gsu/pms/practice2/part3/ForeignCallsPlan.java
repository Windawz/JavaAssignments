package by.gsu.pms.practice2.part3;

import by.gsu.pms.practice2.CallTime;
import by.gsu.pms.practice2.ForeignCountry;
import by.gsu.pms.practice2.Money;
import by.gsu.pms.practice2.Period;

import java.util.EnumSet;
import java.util.Optional;

public class ForeignCallsPlan extends TimeLimitedPlan {
    public static final int EXTRA_MINUTES_PER_COUNTRY = 30;

    public ForeignCallsPlan(
        Money fee,
        Period period,
        CallTime callTime,
        EnumSet<ForeignCountry> foreignCountries
    ) {
        super(fee, period, callTime);
        _foreignCountries = EnumSet.copyOf(foreignCountries);
    }

    private final EnumSet<ForeignCountry> _foreignCountries;

    @Override
    public Optional<EnumSet<ForeignCountry>> tryGetForeignCountries() {
        return Optional.of(getForeignCountries());
    }

    @Override
    public CallTime getCallTime() {
        int baseMinutes = super
            .getCallTime()
            .getMinuteCount();
        int modifier =
            EXTRA_MINUTES_PER_COUNTRY
            * _foreignCountries.size();
        return new CallTime(baseMinutes + modifier);
    }

    public EnumSet<ForeignCountry> getForeignCountries() {
        return EnumSet.copyOf(_foreignCountries);
    }
}
