package com.example.shop.express.mapper;

import com.example.shop.express.entity.Customer;
import com.example.shop.express.model.request.CustomerCreateRequest;
import com.example.shop.express.model.response.CustomerCreateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer mapCustomerRequest(CustomerCreateRequest customerCreateRequest);


    CustomerCreateResponse mapCustomerResponse(Customer customer);
}
