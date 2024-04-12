package nl.rabobank.axondemo.event;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class FlightScheduledEvent {

    private final String id;
    private final String flightId;

    public FlightScheduledEvent(String id, String flightId) {
        this.id = id;
        this.flightId = flightId;
    }
}
