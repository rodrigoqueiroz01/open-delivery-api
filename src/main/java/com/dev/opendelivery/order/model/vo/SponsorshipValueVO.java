package com.dev.opendelivery.order.model.vo;

import com.dev.opendelivery.order.model.enums.NameType;
import com.dev.opendelivery.order.util.BaseSerializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SponsorshipValueVO extends BaseSerializable {

    @JsonProperty("")
    private NameType name;

    @JsonProperty("")
    private PriceVO amount;

}
