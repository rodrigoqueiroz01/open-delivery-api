package com.dev.opendelivery.order.model.enums;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;
import java.util.stream.*;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.OBJECT;
import static io.vavr.API.Try;
import static java.lang.String.format;

@Getter
@AllArgsConstructor
@JsonFormat(shape = OBJECT)
public enum Timing {

    INSTANT("instantaneo"),
    SCHEDULED("agendado");

    @JsonProperty("descricao")
    private final String description;

    public static Timing fromJsonNode(JsonNode jsonNode) {
        return fromString(Try(() -> jsonNode.get("descricao").asText()).getOrElse(jsonNode.asText()));
    }

    public static Timing fromString(String description) {
        return Stream.of(values()).filter(t -> t.description.equals(description)).findFirst().orElseThrow(() ->
                new IllegalArgumentException(format("O tipo '%s' não corresponde a um tipo válido. Tipos disponíveis: %s",
                        description, Stream.of(values()).map(Timing::getDescription).collect(Collectors.joining(", "))
                ))
        );
    }

}
