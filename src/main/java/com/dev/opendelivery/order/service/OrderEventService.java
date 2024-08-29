package com.dev.opendelivery.order.service;

import com.dev.opendelivery.order.model.*;
import com.dev.opendelivery.order.model.vo.OrderConfirmVO;
import com.dev.opendelivery.order.repository.OrderEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;

import static com.dev.opendelivery.order.model.enums.EventType.*;
import static java.time.ZoneOffset.UTC;
import static java.util.Objects.*;
import static java.util.concurrent.CompletableFuture.completedFuture;

@Service
@AllArgsConstructor
public class OrderEventService {

    private final OrderEventRepository repository;

    @Async
    public void orderCreate(UUID orderId, SourceApp sourceAppId) {
        var event = Event.builder()
                .eventType(CREATED)
                .orderId(orderId)
                .sourceApp(sourceAppId)
                .build();

        completedFuture(save(event));
    }

    @Async
    public void orderConfirm(UUID orderId, SourceApp sourceApp, OrderConfirmVO confirm) {
        var event = Event.builder()
                .eventType(CONFIRMED)
                .orderId(orderId)
                .sourceApp(sourceApp)
                .build();
        save(event);
    }

    @Async
    public void orderCancel(UUID orderId, SourceApp sourceApp) {
        var event = Event.builder()
                .eventType(CANCELLED)
                .orderId(orderId)
                .sourceApp(sourceApp)
                .build();
        save(event);
    }

    @Async
    public void orderReadyForPickup(UUID orderId, SourceApp sourceAppId) {
        var event = Event.builder()
                .eventType(READY_FOR_PICKUP)
                .orderId(orderId)
                .sourceApp(sourceAppId)
                .build();
        save(event);
    }

    @Async
    public void orderDispatch(UUID orderId, SourceApp sourceApp) {
        var event = Event.builder()
                .eventType(DISPATCHED)
                .orderId(orderId)
                .sourceApp(sourceApp)
                .build();
        save(event);
    }

    public Event save(Event event) {
        if (isNull(event.getId())) event.setId(UUID.randomUUID());
        if (isNull(event.getCreatedAt())) event.setCreatedAt(LocalDateTime.now());
        return repository.save(event);
    }

    public boolean accept(UUID eventId, UUID sourceAppId) {
        var event = repository.findByIdAndSourceAppId(eventId, sourceAppId);
        if (nonNull(event)) {
            event.setAcceptedAt(new Date());
            repository.save(event);
            return true;
        } else {
            return false;
        }
    }

    public List<Event> getEventsNotAcceptedBySourceApp(UUID sourceAppId) {
        var eightHoursAgo = LocalDateTime.now(UTC).minusHours(8);
        var eventsData = repository.getEventsNotAcceptedByTheSourceApplication(sourceAppId, eightHoursAgo);
        List<Event> events = new ArrayList<>();

        if (nonNull(eventsData)) {
            eventsData.forEach(event -> {
                event.getDate();
                events.add(event);
            });
        }

        return events;
    }

}
