package nl.rabobank.axondemo.api;

import java.util.concurrent.TimeUnit;

import nl.rabobank.axondemo.command.ScheduleFlightCommand;
import nl.rabobank.axondemo.model.ScheduleFlightRequest;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.config.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FligthController {

    private final Configuration configuration;

    public FligthController(Configuration configuration) {
        this.configuration = configuration;

    }

    @PostMapping(value = "/scheduleFlight", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus scheduleFlight(@RequestBody ScheduleFlightRequest scheduleFlightRequest) {

        // Obtain a `CommandGateway` instance
        CommandGateway commandGateway = configuration.commandGateway();

        try {
            Object resultSync = commandGateway.sendAndWait(
                    new ScheduleFlightCommand(scheduleFlightRequest.getId()), 500, TimeUnit.MILLISECONDS
                                                          );
            return HttpStatus.OK;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

}
