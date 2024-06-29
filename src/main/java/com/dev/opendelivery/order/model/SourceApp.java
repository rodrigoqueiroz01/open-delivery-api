package com.dev.opendelivery.order.model;

import com.dev.opendelivery.order.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

import static jakarta.persistence.GenerationType.AUTO;

@Getter
@Entity
@Table(name = "source_app", schema = "public")
public class SourceApp extends BaseEntity<UUID> {

    @JsonProperty("descricao")
    @Column(name = "description", unique = true, length = 100)
    private String description;

}
