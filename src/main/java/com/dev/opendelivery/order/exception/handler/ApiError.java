package com.dev.opendelivery.order.exception.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private final LocalDateTime timestamp = LocalDateTime.now();

    private String title;
    private Integer status;
    private String detail;
    private List<Field> fields;

    @Getter
    @Builder
    public static class Field {
        private String name;
        private String message;
    }

}
