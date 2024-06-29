package com.dev.opendelivery.order.model.vo;

import com.dev.opendelivery.order.util.BaseSerializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DeliveryAddress extends BaseSerializable {

    @JsonProperty("pais")
    private String country;

    @JsonProperty("estado")
    private String state;

    @JsonProperty("cidade")
    private String city;

    @JsonProperty("bairro")
    private String district;

    @JsonProperty("rua")
    private String street;

    @JsonProperty("numero")
    private String number;

    @JsonProperty("complemento")
    private String complement;

    @JsonProperty("referencia")
    private String reference;

    @JsonProperty("formatoEndereco")
    private String formattedAddress;

    @JsonProperty("cartaoPostal")
    private String postalCode;

    @JsonProperty("coordenadas")
    private CoordinatesVO coordinatesVO;

    public String formattedAddress() {
        return getStreet() + ", " +
                getNumber() + ", " +
                getComplement() + ", " +
                getDistrict() + " - " +
                getCity() + ", " +
                getState();
    }

}
