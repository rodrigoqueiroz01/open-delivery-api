package com.dev.opendelivery.order.exception.handler;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;
import static java.time.LocalDateTime.now;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    @JsonFormat(shape = STRING, pattern = "dd-MM-yyyy HH:mm")
    private final LocalDateTime timestamp = now();

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
