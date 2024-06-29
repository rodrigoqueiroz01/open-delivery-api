package com.dev.opendelivery.order.model.vo;

import com.dev.opendelivery.order.util.BaseSerializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderItemVO extends BaseSerializable {

    @JsonProperty("")
    private String orderItemId;

    @JsonProperty("")
    private Integer index;

    @JsonProperty("")
    private String name;

    @JsonProperty("")
    private String externalCode;

    @JsonProperty("")
    private String unit;

    @JsonProperty("")
    private String ean;

    @JsonProperty("")
    private Integer quantity;

    @JsonProperty("")
    private String specialInstructions;

    @JsonProperty("")
    private PriceVO unitPriceVO;

    @JsonProperty("")
    private PriceVO optionsPriceVO;

    @JsonProperty("")
    private PriceVO totalPriceVO;

    @JsonProperty("")
    private List<OrderItemVO> options;

}
