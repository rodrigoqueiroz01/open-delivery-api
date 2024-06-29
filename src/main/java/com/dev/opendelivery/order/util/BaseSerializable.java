package com.dev.opendelivery.order.util;

import jakarta.persistence.MappedSuperclass;
import java.io.Serial;
import java.io.Serializable;

@MappedSuperclass
public class BaseSerializable implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

}
