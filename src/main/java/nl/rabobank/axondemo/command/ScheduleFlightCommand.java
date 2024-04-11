package nl.rabobank.axondemo.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Value;

@Value
public class ScheduleFlightCommand {

    @TargetAggregateIdentifier
    String id;
}
