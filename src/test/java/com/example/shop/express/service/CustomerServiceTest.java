package com.example.shop.express.service;

import com.example.shop.express.entity.Customer;
import com.example.shop.express.model.request.CustomerCreateRequest;
import com.example.shop.express.model.response.CustomerCreateResponse;
import com.example.shop.express.reposervice.CustomerRepoService;
import com.example.shop.express.repository.CustomerRepository;
import com.example.shop.express.util.CustomerUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    private ICustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerRepoService customerRepoService;

    @Test
    public void TestCreateUser() {
        CustomerCreateRequest customerRequest = CustomerUtil.getCustomerCreateRequest();
        Customer customer = CustomerUtil.getCustomer();
        CustomerCreateResponse customerResponse = CustomerUtil.getCustomerCreateResponse();
//        Mockito.doReturn(Collections.emptyList()).when(customerRepoService)
//        Mockito.doReturn(Collections.emptyList()).when(itemRepoService)
//                .getItemByName(Mockito.anyString());
//        Mockito.doReturn(Collections.emptyList()).when(itemRepoService)
//                .getItemByCode(Mockito.anyString());
//        Mockito.doReturn(item).when(itemRepoService).saveItem(Mockito.any());
//        ItemResponse actualResponse = itemService.createItem(itemRequest);
//        Assert.assertEquals(itemResponse, actualResponse);

        CustomerCreateResponse actualResponse = customerService.createCustomer(customerRequest);
        Assert.assertEquals(customerResponse,actualResponse);

    }
}
