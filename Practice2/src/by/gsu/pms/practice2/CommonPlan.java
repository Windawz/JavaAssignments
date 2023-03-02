package by.gsu.pms.practice2;

import java.util.EnumSet;
import java.util.Optional;

public interface CommonPlan {
    Optional<Money> tryGetFee();
    Optional<Period> tryGetPeriod();
    Optional<Traffic> tryGetTraffic();
    Optional<CallTime> tryGetCallTime();
    Optional<EnumSet<ForeignCountry>> tryGetForeignCountries();
}
