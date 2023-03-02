package by.gsu.pms.practice2;

import java.util.EnumSet;
import java.util.Optional;

public interface CommonPlan {
    Optional<Money> getFee();
    Optional<Period> getPeriod();
    Optional<Traffic> getTraffic();
    Optional<CallTime> getCallTime();
    Optional<EnumSet<ForeignCountry>> getForeignCountries();
}
