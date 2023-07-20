package com.example.shop.express.model.response.payment;

import com.example.shop.express.entity.Order;
import com.example.shop.express.entity.User;
import com.example.shop.express.enums.PaymentMode;
import com.example.shop.express.enums.PaymentStatus;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PaymentResponse {

    private Integer Id;

    private Long paymentDate;

    private PaymentMode mode;

    private PaymentStatus status;

    private Long amount;

    private Order order;

    private User user;

}
