package com.dev.opendelivery.order.model.vo;

import com.dev.opendelivery.order.util.BaseSerializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderTotalVO extends BaseSerializable {

    @JsonProperty("")
    private PriceVO itemsPriceVO;

    @JsonProperty("")
    private PriceVO otherFees;

    @JsonProperty("")
    private PriceVO discount;

    @JsonProperty("")
    private PriceVO orderAmount;

}
