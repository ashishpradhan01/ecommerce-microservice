package com.prime.ecommerce.service;

import com.prime.ecommerce.mapper.OrderLineMapper;
import com.prime.ecommerce.record.OrderLineRequest;
import com.prime.ecommerce.record.OrderLineResponse;
import com.prime.ecommerce.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderLineServiceImpl implements OrderLineService{
    private final OrderLineRepository repository;
    private final OrderLineMapper mapper;

    @Override
    public Integer saveOrderLine(OrderLineRequest request) {
        var order = mapper.toOrderLine(request);
        return repository.save(order).getId();
    }

    @Override
    public List<OrderLineResponse> findAllByOrderId(Integer orderId) {
        return repository.findAllByOrderId(orderId)
                .stream()
                .map(mapper::toOrderLineResponse)
                .collect(Collectors.toList());
    }
}
