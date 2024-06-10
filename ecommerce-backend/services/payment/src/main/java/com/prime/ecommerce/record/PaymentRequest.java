package com.prime.ecommerce.record;

import com.prime.ecommerce.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
    Integer id,
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderReference,
    Customer customer
) {
}