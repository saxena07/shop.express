package com.example.shop.express.mapper;

import com.example.shop.express.entity.Payment;
import com.example.shop.express.model.response.payment.PaymentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel= "spring")
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);


    PaymentResponse mapPaymentResponse(final Payment payment);
}
