package com.dev.opendelivery.order.model.vo;

import com.dev.opendelivery.order.model.enums.DeliveredBy;
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
public class DeliveryVO extends BaseSerializable {

    @JsonProperty("entreguePor")
    private DeliveredBy deliveredBy;

    @JsonProperty("enderecoEntrega")
    private DeliveryAddress deliveryAddress;

    @JsonProperty("dataHoraEntregaEstimada")
    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime estimatedDeliveryDateTime;

    @JsonProperty("dataHoraEntrega")
    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime deliveryDateTime;

}
