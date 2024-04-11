package nl.rabobank.axondemo.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class ScheduleFlightCommand {

    @TargetAggregateIdentifier
    private final String id;
    // other state


    public ScheduleFlightCommand(String id /*, other state */) {
        this.id = id;
        // setting state
    }


    // getters, equals, hashCode, toString
}
