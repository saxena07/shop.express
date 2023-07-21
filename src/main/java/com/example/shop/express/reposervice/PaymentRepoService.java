package com.example.shop.express.reposervice;

import com.example.shop.express.entity.Payment;
import com.example.shop.express.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentRepoService {

    @Autowired
    private PaymentRepository paymentRepository;


    public Payment fetchPayment(final  Integer id) {
        return paymentRepository.getReferenceById(id);
    }

    public Payment CreateOrUpdatePayment(final Payment payment)
    {
       return paymentRepository.save(payment);
    }
    public Payment fetchPaymentByOrderAndUser(final Integer userId,final Integer orderId )
    {
        return paymentRepository.findPaymentByOrder_IdAndUser_Id(orderId,userId).orElseThrow(null);
    }
}
