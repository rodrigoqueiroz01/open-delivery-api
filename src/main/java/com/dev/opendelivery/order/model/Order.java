package com.dev.opendelivery.order.model;

import com.dev.opendelivery.order.model.vo.OrderConfirmVO;
import com.dev.opendelivery.order.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
public class Order extends BaseEntity<UUID> {

    @ManyToOne
    @JsonProperty("idAppOrigem")
    private SourceApp sourceApp;

    @JsonProperty("criadoEm")
    @Column(name = "created_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @JsonProperty("idComerciante")
    @Column(name = "merchant_id", nullable = false, unique = true)
    private UUID merchantId;

    @JsonProperty("data")
    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "order_external_code")
    private String orderExternalCode;

}
