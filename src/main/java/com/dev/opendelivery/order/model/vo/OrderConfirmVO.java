package com.dev.opendelivery.order.model.vo;

import com.dev.opendelivery.order.util.BaseSerializable;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderConfirmVO extends BaseSerializable {

    @JsonProperty("confirmado")
    private Boolean confirmed = false;

    @JsonProperty("confirmadoEm")
    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime confirmedAt;

    @JsonProperty("codigoExternoPedido")
    private String orderExternalCode;

}
