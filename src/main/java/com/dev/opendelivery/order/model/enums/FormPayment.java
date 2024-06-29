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
public enum FormPayment {

    CREDIT("credito"),
    DEBIT("debito"),
    MEAL_VOUCHER("valeRefeicao"),
    FOOD_VOUCHER("valeAlimentacao"),
    DIGITAL_WALLET("carteiraDigital"),
    PIX("pix"),
    CASH("dinheiro"),
    CREDIT_DEBIT("creditoDebito"),
    COUPON("cupom"),
    REDEEM("resgatar"),
    PREPAID_REDEEM("resgatarPrePago"),
    OTHER("outros");

    @JsonProperty("descricao")
    private final String description;

    public static FormPayment fromJsonNode(JsonNode jsonNode) {
        return fromString(Try(() -> jsonNode.get("descricao").asText()).getOrElse(jsonNode.asText()));
    }

    public static FormPayment fromString(String description) {
        return Stream.of(values()).filter(p -> p.description.equals(description)).findFirst().orElseThrow(() ->
                new IllegalArgumentException(format("O tipo '%s' não corresponde a um tipo válido. Tipos disponíveis: %s.",
                        description, Stream.of(values()).map(FormPayment::getDescription).collect(Collectors.joining(", "))
                ))
        );
    }

}
