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
public enum TakeoutMode {

    DEFAULT("padrao"),
    PICKUP_AREA("areaRetirada");

    @JsonProperty("descricao")
    private final String description;

    public static TakeoutMode fromJsonNode(JsonNode jsonNode) {
        return fromString(Try(() -> jsonNode.get("descricao").asText()).getOrElse(jsonNode.asText()));
    }

    public static TakeoutMode fromString(String description) {
        return Stream.of(values()).filter(m -> m.description.equals(description)).findFirst().orElseThrow(() ->
                new IllegalArgumentException(format("O tipo '%s' não corresponde a um tipo válido. Tipos disponíveis: %s",
                        description, Stream.of(values()).map(TakeoutMode::getDescription).collect(Collectors.joining(", "))
                ))
        );
    }

}
