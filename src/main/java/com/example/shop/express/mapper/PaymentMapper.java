package com.example.shop.express.mapper;

import com.example.shop.express.entity.Payment;
import com.example.shop.express.model.request.payment.PaymentRequest;
import com.example.shop.express.model.response.payment.PaymentResponse;
import com.example.shop.express.reposervice.OrderRepoService;
import com.example.shop.express.reposervice.UserRepoService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel= "spring",uses = {UserRepoService.class, OrderRepoService.class})
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);


    @Mapping(source ="userId",target = "user",qualifiedByName = "getUser")
    @Mapping(source ="orderId",target = "order",qualifiedByName = "getOrder")
    Payment mapPayment(final PaymentRequest paymentRequest);

    Payment mapPayment(PaymentRequest paymentRequest,@MappingTarget Payment payment);

    @Mapping(target = "userId",source = "payment.user.id")
    @Mapping(target = "orderId",source = "payment.order.id")
    PaymentResponse mapPaymentResponse(final Payment payment);
}
