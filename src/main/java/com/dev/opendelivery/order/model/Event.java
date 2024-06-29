package com.dev.opendelivery.order.model;

import com.dev.opendelivery.order.model.enums.EventType;
import com.dev.opendelivery.order.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "event_data", schema = "opendelivery")
public class Event extends BaseEntity<UUID> {

    @ManyToOne
    @JoinColumn(name = "source_app_id")
    @JsonProperty("idAppOrigem")
    private SourceApp sourceApp;

    @JsonProperty("idPedido")
    @Column(name = "order_id", nullable = false, unique = true)
    private UUID orderId;

    @JsonProperty("criadoEm")
    @Column(name = "created_at", updatable = false, insertable = false, nullable = false)
    private LocalDateTime createdAt;

    @JsonProperty("data")
    @Column(name = "date", nullable = false)
    private Date date;

    @JsonProperty("aceitoEm")
    @Column(name = "accepted_at", nullable = false)
    private Date acceptedAt;

    @JsonProperty("tipoEvento")
    @Column(name = "event_type", nullable = false)
    private EventType eventType;

    @Transient
    @JsonIgnore
    @JsonProperty("oitoHorasAtras")
    private LocalDateTime eightHoursAgo;

}
