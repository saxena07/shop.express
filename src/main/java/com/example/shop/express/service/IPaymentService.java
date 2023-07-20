package com.example.shop.express.service;

import com.example.shop.express.model.request.payment.PaymentRequest;
import com.example.shop.express.model.response.payment.PaymentResponse;

public interface IPaymentService {
    PaymentResponse createPayment(final PaymentRequest paymentRequest);

    PaymentResponse fetchPayment(final Integer id);
}
