package com.example.shop.express.reposervice;

import com.example.shop.express.entity.Customer;
import com.example.shop.express.repository.CustomerRepository;
import com.example.shop.express.util.CustomerUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CustomerRepoServiceTest {


    @InjectMocks
    private CustomerRepoService customerRepoService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void testCreateCustomer() {

        Customer customer= CustomerUtil.getCustomer();
        Mockito.doReturn(customer).when(customerRepoService).createCustomer(customer);
        Customer actualResponse = customerRepoService.createCustomer(customer);
        Assert.assertEquals(customer,actualResponse);

    }
}
