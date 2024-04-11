package nl.rabobank.axondemo.event;

import lombok.Getter;

@Getter
public class FlightScheduledEvent {

    private final String flightId;

    public FlightScheduledEvent(String flightId) {
        this.flightId = flightId;
    }
}
