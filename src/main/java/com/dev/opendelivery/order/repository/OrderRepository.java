package com.dev.opendelivery.order.repository;

import com.dev.opendelivery.order.model.Order;
import com.dev.opendelivery.order.model.SourceApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Query("SELECT DISTINCT o.sourceApp.id FROM Order o WHERE o.merchantId = :merchantId")
    List<Order> findAllSourceAppIdByMerchantId(UUID merchantId);

    @Query("SELECT o FROM Order o WHERE o.orderExternalCode = :externalCode")
    Optional<Order> confirmOrderByExternalCode(String externalCode);

    @Query("SELECT o.sourceApp FROM Order o WHERE o.merchantId = :merchantId")
    List<SourceApp> findSourceAppsByMerchantId(@Param("merchantId") String merchantId);

}
