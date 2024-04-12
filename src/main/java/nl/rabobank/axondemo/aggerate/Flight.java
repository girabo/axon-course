package nl.rabobank.axondemo.aggerate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import lombok.NoArgsConstructor;
import nl.rabobank.axondemo.command.ScheduleFlightCommand;
import nl.rabobank.axondemo.event.FlightScheduledEvent;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
public class Flight {

    @AggregateIdentifier
    private String aggregateId;

    @CommandHandler
    public Flight(ScheduleFlightCommand command) {
        apply(new FlightScheduledEvent(command.getId(), command.getFlightId()));
    }

    @EventSourcingHandler
    public void on(FlightScheduledEvent event) {
        this.aggregateId = event.getId();
    }
}
