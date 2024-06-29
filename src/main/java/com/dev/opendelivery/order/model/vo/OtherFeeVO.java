package com.dev.opendelivery.order.model.vo;

import com.dev.opendelivery.order.util.BaseSerializable;
import com.dev.opendelivery.order.model.enums.OtherFeeType;
import com.dev.opendelivery.order.model.enums.ReicevedByType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OtherFeeVO extends BaseSerializable {

    @JsonProperty("")
    private String name;

    @JsonProperty("")
    private OtherFeeType type;

    @JsonProperty("")
    private ReicevedByType reicevedBy;

    @JsonProperty("")
    private String receiverDocument;

    @JsonProperty("")
    private PriceVO priceVO;

    @JsonProperty("")
    private String observation;

}
