package com.example.shop.express.service;

import com.example.shop.express.model.request.CustomerCreateRequest;
import com.example.shop.express.model.response.CustomerCreateResponse;


public interface ICustomerService {

    CustomerCreateResponse createCustomer(final CustomerCreateRequest customerCreateRequest);
}
