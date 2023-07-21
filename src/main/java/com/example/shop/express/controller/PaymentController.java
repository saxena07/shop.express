package com.example.shop.express.controller;

import com.example.shop.express.model.request.payment.PaymentRequest;
import com.example.shop.express.model.response.payment.PaymentResponse;
import com.example.shop.express.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/payments")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;
    @PostMapping
    public PaymentResponse addPaymentDetails(@RequestBody final PaymentRequest paymentRequest)
    {
        return paymentService.addPaymentDetails(paymentRequest);

    }

    @GetMapping(value = "/{id}")
    public PaymentResponse fetchPayment(@PathVariable("id") final Integer id)
    {
        return paymentService.fetchPayment(id);
    }
}
