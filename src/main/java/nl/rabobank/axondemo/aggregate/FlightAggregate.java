package nl.rabobank.axondemo.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import nl.rabobank.axondemo.command.ScheduleFlightCommand;
import nl.rabobank.axondemo.event.FlightScheduledEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
public class FlightAggregate {
    private static final Logger LOGGER = LogManager.getLogger(FlightAggregate.class);


    @AggregateIdentifier
    private String aggregateId;

    @CommandHandler
    public FlightAggregate(ScheduleFlightCommand command) {
        LOGGER.info("AGGERATE - Flight scheduled command received: {}", command.toString());
        apply(new FlightScheduledEvent(command.getId(), command.getFlightId()));
    }

    @EventSourcingHandler
    public void on(FlightScheduledEvent event) {
        LOGGER.info("AGGERATE - EventSourcingHandler - Flight scheduled event received: {}", event.toString());
        this.aggregateId = event.getId();
    }
}
