package com.dev.opendelivery.order.api.rest;

import com.dev.opendelivery.order.api.interfaces.IEventController;
import com.dev.opendelivery.order.model.Event;
import com.dev.opendelivery.order.model.SourceApp;
import com.dev.opendelivery.order.service.OrderEventService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Log
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/events")
public class EventController implements IEventController {

    private final OrderEventService service;

    @GetMapping(value = "polling")
    public ResponseEntity<List<Event>> getEvents(@RequestHeader("X-API-KEY") String apiKey) throws Exception {
        log.info("GET /v1/events:polling");

        // TODO get sourceAppId pela apiKey
        var sourceApp = new SourceApp();
        List<Event> events = service.getEventsNotAcceptedBySourceApp(sourceApp.getId());

        if (!events.isEmpty()) {
            return ResponseEntity.ok().body(events);
        } else {
            return ResponseEntity.status(NO_CONTENT).build();
        }
    }

    @PostMapping("/acknowledgment")
    public ResponseEntity<Event> acknowledgmentEvent(@RequestBody final Event event, @RequestHeader("X-API-KEY") String apiKey) throws Exception {
        log.info("POST /v1/events/acknowledgment");

        // TODO criar DTO EventAck conforme documentação

        // TODO get sourceAppId pela apiKey
        SourceApp sourceAppId = new SourceApp();

        if (service.accept(event.getId(), sourceAppId.getId())) {
            return ResponseEntity.status(ACCEPTED).build();
        } else {
            return ResponseEntity.status(BAD_REQUEST).build();
        }
    }

}
