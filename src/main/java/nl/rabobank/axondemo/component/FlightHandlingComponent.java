package nl.rabobank.axondemo.component;

import nl.rabobank.axondemo.command.ScheduleFlightCommand;

import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Component;

@Component
public class FlightHandlingComponent {
    @CommandHandler
    public void handle(ScheduleFlightCommand command) {
        System.out.println("Handling ScheduleFlightCommand, id is: " + command.getId());
    }

}
