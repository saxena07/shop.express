package com.example.shop.express.model.request.shipment;

import com.example.shop.express.constant.ErrorConstant;
import com.example.shop.express.entity.ContactDetail;
import com.example.shop.express.entity.Order;
import com.example.shop.express.entity.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShipmentRequest {

    private Integer orderId;

   // @NotEmpty(message = ErrorConstant.ID_IS_MANDATORY)
    private Integer userId;

   // @NotEmpty(message = ErrorConstant.ID_IS_MANDATORY)
    private Integer contactDetailId;

    private Long dateTime;

}
