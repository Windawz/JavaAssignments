package by.gsu.pms.practice2;

import java.util.EnumSet;
import java.util.Optional;

public interface CommonPlan {
    Optional<Money> tryGetFee();
    Optional<Period> tryGetPeriod();
    Optional<Traffic> tryGetTraffic();
    Optional<CallTime> tryGetCallTime();
    Optional<EnumSet<ForeignCountry>> tryGetForeignCountries();

    default String getInfoString() {
        var builder = new StringBuilder();
        tryGetFee().ifPresent(
            fee -> builder.append("Fee: " + fee + "; "));
        tryGetPeriod().ifPresent(
            period -> builder.append("Period: " + period + "; "));
        tryGetTraffic().ifPresent(
            traffic -> builder.append("Traffic: " + traffic + "; "));
        tryGetCallTime().ifPresent(
            callTime -> builder.append("Call Time: " + callTime + "; "));
        tryGetForeignCountries().ifPresent(
            foreignCountries -> builder.append(
                "Foreign Countries: "
                    + String.join(
                    ", ",
                    foreignCountries
                        .stream()
                        .map(country -> country.toString())
                        .toList())
                    + ";"));
        return builder.toString();
    }
}
