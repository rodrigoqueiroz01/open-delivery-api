package com.dev.opendelivery.order.model.vo;

import com.dev.opendelivery.order.util.BaseSerializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderScheduleVO extends BaseSerializable {

    @JsonProperty("")
    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime scheduledDateTimeStart;

    @JsonProperty("")
    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime scheduledDateTimeEnd;

}
