package by.gsu.pms.practice2;

import java.util.EnumSet;
import java.util.Optional;

public interface CommonPlan {
    default Optional<Money> tryGetFee() {
        return Optional.empty();
    }

    default Optional<Period> tryGetPeriod() {
        return Optional.empty();
    }

    default Optional<Traffic> tryGetTraffic() {
        return Optional.empty();
    }

    default Optional<CallTime> tryGetCallTime() {
        return Optional.empty();
    }

    default Optional<EnumSet<ForeignCountry>> tryGetForeignCountries() {
        return Optional.empty();
    }


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
