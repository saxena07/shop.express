package com.example.shop.express.service.impl;

import com.example.shop.express.mapper.CustomerMapper;
import com.example.shop.express.model.request.CustomerCreateRequest;
import com.example.shop.express.model.response.CustomerCreateResponse;
import com.example.shop.express.reposervice.CustomerRepoService;
import com.example.shop.express.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    @Autowired
    private CustomerRepoService customerRepoService;

    @Override
    public CustomerCreateResponse createCustomer(CustomerCreateRequest customerCreateRequest) {

        customerRepoService.createCustomer(
                customerMapper.mapCustomerRequest(customerCreateRequest));

        return customerMapper.mapCustomerResponse(customerRepoService.createCustomer(
                customerMapper.mapCustomerRequest(customerCreateRequest)));

    }
}
