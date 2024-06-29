package com.dev.opendelivery.order.model.vo;

import com.dev.opendelivery.order.model.enums.TargetType;
import com.dev.opendelivery.order.util.BaseSerializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.vavr.collection.List;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DiscountVO extends BaseSerializable {

    @JsonProperty("quantidade")
    private PriceVO amount;

    @JsonProperty("alvo")
    private TargetType target;

    @JsonProperty("idAlvo")
    private String targetId;

    @JsonProperty("valoresPatriocinio")
    private List<SponsorshipValueVO> sponsorshipValues;

}
