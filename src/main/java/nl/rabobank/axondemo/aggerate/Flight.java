package nl.rabobank.axondemo.aggerate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import nl.rabobank.axondemo.command.ScheduleFlightCommand;
import nl.rabobank.axondemo.event.FlightScheduledEvent;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate(
        repository = "flightRepository"
)
public class Flight {

    @AggregateIdentifier
    private String aggregateId;

    @CommandHandler
    public void handle(ScheduleFlightCommand command) {
        apply(new FlightScheduledEvent(command.getFlightId()));
    }
}
