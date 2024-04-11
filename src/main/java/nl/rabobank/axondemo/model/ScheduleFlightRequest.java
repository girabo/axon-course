package nl.rabobank.axondemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public final class ScheduleFlightRequest {

    @JsonProperty("id")
    private String id;

    @JsonProperty("flightId")
    private String flightId;

}
