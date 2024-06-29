package com.dev.opendelivery.order.model.enums;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;

import java.util.stream.*;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.OBJECT;
import static java.lang.String.format;
import static io.vavr.API.Try;

@Getter
@AllArgsConstructor
@JsonFormat(shape = OBJECT)
public enum DeliveredBy {

    MERCHANT("comerciante"),
    MARKETPLACE("mercado");

    @JsonProperty("descricao")
    private final String description;

    public static DeliveredBy fromJsonNode(JsonNode jsonNode) {
        return fromString(Try(() -> jsonNode.get("descricao").asText()).getOrElse(jsonNode.asText()));
    }

    public static DeliveredBy fromString(String description) {
        return Stream.of(values()).filter(d -> d.description.equals(description)).findFirst().orElseThrow(() ->
                new IllegalArgumentException(format("O tipo '%s' não corresponde a um tipo válido. Tipos disponíveis: %s.",
                        description, Stream.of(values()).map(DeliveredBy::getDescription).collect(Collectors.joining(", "))
                ))
        );
    }

}