package com.prime.ecommerce.service;

import com.prime.ecommerce.record.PaymentRequest;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    Integer createPayment(PaymentRequest request);
}
