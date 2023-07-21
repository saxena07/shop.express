package com.example.shop.express.model.request.order;

import com.example.shop.express.constant.Constant;
import com.example.shop.express.enums.OrderStatus;
import com.example.shop.express.model.request.orderItem.OrderItemRequest;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateOrderRequest {

//    @NotBlank(message = Constant.PROVIDE_ALL_ORDER_DETAILS)
    private Long orderedAt;

    private OrderStatus status;

    @NotNull(message = Constant.PROVIDE_ALL_ORDER_DETAILS)
    private Double totalAmount;

    private Integer shipmentId;

    @NotNull(message = Constant.PROVIDE_ALL_CATEGORY_DETAILS)
    private Integer userId;

    @NotNull(message = Constant.PROVIDE_ALL_CATEGORY_DETAILS)
    private List<OrderItemRequest> orderItems;

}
