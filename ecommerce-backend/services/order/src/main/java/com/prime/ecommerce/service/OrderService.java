package com.prime.ecommerce.service;

import com.prime.ecommerce.record.OrderRequest;
import com.prime.ecommerce.record.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Integer createOrder(OrderRequest request);

    List<OrderResponse> findAllOrders();

    OrderResponse findById(Integer id);
}
