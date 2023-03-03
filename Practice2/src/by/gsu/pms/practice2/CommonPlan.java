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
            fee -> builder
                .append("Fee: ")
                .append(fee)
                .append("; "));
        tryGetPeriod().ifPresent(
            period -> builder
                .append("Period: ")
                .append(period)
                .append("; "));
        tryGetTraffic().ifPresent(
            traffic -> builder
                .append("Traffic: ")
                .append(traffic)
                .append("; "));
        tryGetCallTime().ifPresent(
            callTime -> builder
                .append("Call Time: ")
                .append(callTime)
                .append("; "));
        tryGetForeignCountries().ifPresent(
            foreignCountries -> builder
                .append("Foreign Countries: "
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
