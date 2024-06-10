package com.prime.ecommerce.service;

import com.prime.ecommerce.record.OrderLineRequest;
import com.prime.ecommerce.record.OrderLineResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface OrderLineService {
    Integer saveOrderLine(OrderLineRequest request);

    List<OrderLineResponse> findAllByOrderId(Integer orderId);
}