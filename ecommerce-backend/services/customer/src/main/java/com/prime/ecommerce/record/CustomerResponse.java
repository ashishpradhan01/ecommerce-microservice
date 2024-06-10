package com.prime.ecommerce.record;

import com.prime.ecommerce.entity.Address;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email,
        Address address
) {

}
