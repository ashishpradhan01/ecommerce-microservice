package com.prime.ecommerce.service;

import com.prime.ecommerce.entity.Customer;
import com.prime.ecommerce.exception.CustomerNotFoundException;
import com.prime.ecommerce.mapper.CustomerMapper;
import com.prime.ecommerce.record.CustomerRequest;
import com.prime.ecommerce.record.CustomerResponse;
import com.prime.ecommerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    @Override
    public String createCustomer(CustomerRequest request) {
        var customer = this.customerRepository.save(mapper.toCustomer(request));
        return customer.getId();
    }

    @Override
    public void updateCustomer(CustomerRequest request) {
        var customer = this.customerRepository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Cannot update customer:: No customer found with the provided ID: %s", request.id())
                ));
        mergeCustomer(customer, request);
        this.customerRepository.save(customer);
    }

    @Override
    public List<CustomerResponse> findAllCustomers() {
        return this.customerRepository.findAll().stream().map(mapper::fromCustomer).toList();
    }

    @Override
    public Boolean existsById(String customerId) {
        return this.customerRepository.findById(customerId).isPresent();
    }

    @Override
    public CustomerResponse findById(String customerId) {
        return this.customerRepository.findById(customerId)
                .map(mapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("No customer found with the provided ID: %s", customerId)
                ));
    }

    @Override
    public void deleteCustomer(String customerId) {
        this.customerRepository.deleteById(customerId);
    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstname())) {
            customer.setFirstname(request.firstname());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }
}
