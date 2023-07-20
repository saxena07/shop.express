package com.example.shop.express.model.response.shipment;

import com.example.shop.express.constant.ErrorConstant;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShipmentResponse {

    private Integer id;

    private Long createdAt;

    private Integer orderId;

    private Integer userId;

    private Integer contactDetailId;

    private Long dateTime;
}
