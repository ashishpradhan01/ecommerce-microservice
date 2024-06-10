package com.prime.ecommerce.record;

public record CustomerResponse(
    String id,
    String firstname,
    String lastname,
    String email
) {

}
