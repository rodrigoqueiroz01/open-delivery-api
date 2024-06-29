package com.dev.opendelivery.order.model.vo;

import com.dev.opendelivery.order.model.enums.OrderTiming;
import com.dev.opendelivery.order.model.enums.OrderType;
import com.dev.opendelivery.order.util.BaseSerializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderVO extends BaseSerializable {

    @JsonProperty("idPedido")
    private String orderId;

    @JsonProperty("idAppOrigem")
    private String sourceAppId;

    @JsonProperty("tipoPedido")
    private OrderType orderType;

    @JsonProperty("idExibicao")
    private String displayId;

    @JsonProperty("criadoEm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime createdAt;

    @JsonProperty("tmepoPedido")
    private OrderTiming orderTiming;

    @JsonProperty("inicioPreparacao")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime preparationStartTime;

    @JsonProperty("comercioPedido")
    private OrderMerchantVO orderMerchantVO;

    @JsonProperty("itensPedidos")
    private List<OrderItemVO> items;

    @JsonProperty("OutrasTaxas")
    private List<OtherFeeVO> otherFeeVOS;

    @JsonProperty("desconto")
    private List<DiscountVO> discountVO;

    @JsonProperty("totalPedido")
    private OrderTotalVO total;

    @JsonProperty("pagamentos")
    private PaymentsVO paymentsVO;

    @JsonProperty("cliente")
    private CustomerVO customerVO;

    @JsonProperty("AgendarPedido")
    private OrderScheduleVO schedule;

    @JsonProperty("entrega")
    private DeliveryVO deliveryVO;

    @JsonProperty("retirarPedido")
    private OrderTakeoutVO takeout;

    @JsonProperty("ordemPedido")
    private OrderIndoorVO indoor;

    @JsonProperty("informacaoExtra")
    private String extraInfo;

}
