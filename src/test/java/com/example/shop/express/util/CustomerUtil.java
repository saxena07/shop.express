package com.example.shop.express.util;

import com.example.shop.express.entity.Customer;
import com.example.shop.express.model.request.CustomerCreateRequest;
import com.example.shop.express.model.response.CustomerCreateResponse;

public class CustomerUtil {
    CustomerUtil()
    {}

    public static CustomerCreateRequest getCustomerCreateRequest()
    {
        return CustomerCreateRequest.builder().build();
    }

    public static Customer getCustomer() {
        return Customer.builder().build();
    }
    public static CustomerCreateResponse getCustomerCreateResponse()
    {
       return CustomerCreateResponse.builder().build();
    }
}
