package com.example.shop.express.service.impl;

import com.example.shop.express.mapper.PaymentMapper;
import com.example.shop.express.model.request.payment.PaymentRequest;
import com.example.shop.express.model.response.payment.PaymentResponse;
import com.example.shop.express.reposervice.PaymentRepoService;
import com.example.shop.express.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private PaymentRepoService paymentRepoService;

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public PaymentResponse createPayment(final PaymentRequest paymentRequest) {
        return null;
    }

    @Override
    public PaymentResponse fetchPayment(final Integer id) {
       return paymentMapper.mapPaymentResponse(paymentRepoService.fetchPayment(id));
    }
}
