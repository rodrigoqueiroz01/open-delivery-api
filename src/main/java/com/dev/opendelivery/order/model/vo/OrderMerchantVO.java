package com.dev.opendelivery.order.model.vo;

import com.dev.opendelivery.order.util.BaseSerializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderMerchantVO extends BaseSerializable {

    @JsonProperty("")
    private String orderMerchantId;

    @JsonProperty("")
    private String name;

}
