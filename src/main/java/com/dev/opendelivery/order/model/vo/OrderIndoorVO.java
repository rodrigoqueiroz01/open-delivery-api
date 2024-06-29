package com.dev.opendelivery.order.model.vo;

import com.dev.opendelivery.order.model.enums.IndoorMode;
import com.dev.opendelivery.order.util.BaseSerializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderIndoorVO extends BaseSerializable {

    @JsonProperty("")
    private IndoorMode mode;

    @JsonProperty("")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime indoorDateTime;

    @JsonProperty("")
    private String place;

}
