package com.prime.ecommerce.service;

import com.prime.ecommerce.exception.ProductPurchaseException;
import com.prime.ecommerce.record.ProductPurchaseRequest;
import com.prime.ecommerce.record.ProductPurchaseResponse;
import com.prime.ecommerce.record.ProductRequest;
import com.prime.ecommerce.record.ProductResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface ProductService {
    Integer createProduct(ProductRequest request);

    ProductResponse findById(Integer id);

    List<ProductResponse> findAll();

    @Transactional(rollbackFor = ProductPurchaseException.class)
    List<ProductPurchaseResponse> purchaseProducts(
            List<ProductPurchaseRequest> request
    );
}
