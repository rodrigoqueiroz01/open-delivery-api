package com.dev.opendelivery.order.api.interfaces;

import com.dev.opendelivery.order.model.Event;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@Tag(name = "Events")
@RequestMapping("/v1/events")
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin(origins = "*", maxAge = 3600)
public interface IEventController {

    @Operation(summary = "Lists all events saved on the system.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful returns list of polled events.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            [
                                               {
                                                 "eventId": "string",
                                                 "eventType": "CREATED",
                                                 "orderId": "string",
                                                 "orderURL": "http://example.com",
                                                 "createdAt": "2019-08-24T14:15:22Z",
                                                 "sourceAppId": "string"
                                               }
                                            ]
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "204",
                    description = "No content.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 400
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Authenticated participant request that violates some authorization rule.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 403
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "503",
                    description = "Service is not currently available. Requested service may be under maintenance or outside the operating window.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 503
                                            }
                                            """
                            )
                    )
            )
    })
    @GetMapping(value = "polling", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Event>> getEvents(String apiKey) throws Exception;

    @Operation(summary = "Acknowledge a set of events, dismissing them from future polling calls.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202",
                    description = "Request has been accepted for processing.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            [
                                               {
                                                 "id": "string",
                                                 "orderId": "string",
                                                 "eventType": "CREATED"
                                               }
                                            ]
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 400
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Authenticated participant request that violates some authorization rule.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 403
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "The requested resource was not found.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 404
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "503",
                    description = "Service is not currently available. Requested service may be under maintenance or outside the operating window.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "title": "Short description of the problem.",
                                              "status": 503
                                            }
                                            """
                            )
                    )
            )
    })
    @PostMapping(value = "/acknowledgment", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity acknowledgmentEvent(@RequestBody final Event event, @RequestHeader("X-API-KEY") String apiKey) throws Exception;

}
