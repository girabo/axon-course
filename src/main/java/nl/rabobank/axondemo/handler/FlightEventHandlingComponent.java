package nl.rabobank.axondemo.handler;

import nl.rabobank.axondemo.event.FlightScheduledEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class FlightEventHandlingComponent {
    private static final Logger LOGGER = LogManager.getLogger(FlightEventHandlingComponent.class);

    @EventHandler
    public void on(FlightScheduledEvent event) {
        LOGGER.info("HANDLER - Flight scheduled event received: {}", event.toString());

        // Perform event handling task…
    }

}
