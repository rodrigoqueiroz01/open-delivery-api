package com.dev.opendelivery.order.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import java.io.*;

import static jakarta.persistence.GenerationType.AUTO;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public abstract class BaseEntity<T extends Serializable> extends BaseSerializable {

    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = AUTO)
    private T id;

}

