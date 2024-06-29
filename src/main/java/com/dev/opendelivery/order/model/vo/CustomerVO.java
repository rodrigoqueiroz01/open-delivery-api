package com.dev.opendelivery.order.model.vo;

import com.dev.opendelivery.order.util.BaseSerializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CustomerVO extends BaseSerializable {

    @JsonProperty("idCliente")
    private String customerId;

    @JsonProperty("Telefone")
    private PhoneVO phoneVO;

    @JsonProperty("numeroDocumento")
    private String documentNumber;

    @JsonProperty("nome")
    private String name;

    @JsonProperty("pedidosContagemComComerciante")
    private Double ordersCountOnMerchant;

}
