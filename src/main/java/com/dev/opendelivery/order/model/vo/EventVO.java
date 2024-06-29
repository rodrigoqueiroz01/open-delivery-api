package com.dev.opendelivery.order.model.vo;

import com.dev.opendelivery.order.model.enums.EventType;
import com.dev.opendelivery.order.util.BaseSerializable;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EventVO extends BaseSerializable {

    @JsonProperty("idEvento")
    private String eventId;

    @JsonProperty("idAppOrigem")
    private String sourceAppId;

    @JsonProperty("tipoEvento")
    private EventType eventType;

    @JsonProperty("idPedido")
    private String orderId;

    @JsonProperty("urlPedido")
    private String orderURL;

    @JsonProperty("criadoEm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime createdAt;


}