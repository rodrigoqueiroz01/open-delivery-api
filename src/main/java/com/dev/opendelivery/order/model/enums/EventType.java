package com.dev.opendelivery.order.model.enums;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import java.util.stream.*;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.OBJECT;
import static io.vavr.API.Try;
import static java.lang.String.format;

@Getter
@AllArgsConstructor
@JsonFormat(shape = OBJECT)
public enum EventType {

    CREATED("criado"),
    CONFIRMED("confirmado"),
    DISPATCHED("despachado"),
    READY_FOR_PICKUP("prontoParaRetirada"),
    PICKUP_AREA_ASSIGNED("areaRetiradaAtribuida"),
    CONCLUDED("concluido"),
    CANCELLATION_REQUESTED("cancelamentoSolicitado"),
    CANCELLATION_REQUEST_DENIED("solicitacaoCancelamentoNegada"),
    CANCELLED("cancelado"),
    ORDER_CANCELLATION_REQUEST("solicitacaoCancelamentoPedido");

    @JsonProperty("descricao")
    private final String description;

    public static EventType fromJsonNode(JsonNode jsonNode) {
        return fromString(Try(() -> jsonNode.get("descricao").asText()).getOrElse(jsonNode.asText()));
    }

    public static EventType fromString(String description) {
        return Stream.of(values()).filter(e -> e.description.equals(description)).findFirst().orElseThrow(() ->
                new IllegalArgumentException(format("O tipo '%s' não corresponde a um tipo válido. Tipos disponíveis: %s.",
                        description, Stream.of(values()).map(EventType::getDescription).collect(Collectors.joining(", "))
                ))
        );
    }

}
