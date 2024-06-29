package com.dev.opendelivery.order.model.vo;

import com.dev.opendelivery.order.model.enums.MethodType;
import com.dev.opendelivery.order.model.enums.FormPayment;
import com.dev.opendelivery.order.util.BaseSerializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MethodVO extends BaseSerializable {

    @JsonProperty("valor")
    private Double value;

    @JsonProperty("moeda")
    private String currency;

    @JsonProperty("tipo")
    private MethodType type;

    @JsonProperty("formaPagamento")
    private FormPayment formPayment;

    @JsonProperty("métodoInfo")
    private String methodInfo;

    @JsonProperty("mudarPara")
    private Double changeFor;

}
