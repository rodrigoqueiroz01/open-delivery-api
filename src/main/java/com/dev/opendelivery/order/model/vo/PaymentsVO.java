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
public class PaymentsVO extends BaseSerializable {

    @JsonProperty("")
    private Double prepaid;

    @JsonProperty("")
    private Double pending;

    @JsonProperty("")
    private List<MethodVO> methodVOS;

}
