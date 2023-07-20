package com.example.shop.express.model.response.order;

import com.example.shop.express.entity.Shipment;
import com.example.shop.express.entity.User;
import com.example.shop.express.enums.OrderStatus;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FetchOrderResponse {

    private Long orderedAt;

    private Double totalAmount;

    private OrderStatus orderStatus;

    private Shipment shipment;

    private User user;

}
