package com.example.shop.express.controller;

import com.example.shop.express.model.request.CustomerCreateRequest;
import com.example.shop.express.model.response.CustomerCreateResponse;
import com.example.shop.express.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping(value = "/create")
    public CustomerCreateResponse create(
            @RequestBody @Valid final CustomerCreateRequest customerCreateRequest) {
        return customerService.createCustomer(customerCreateRequest);

    }


}
