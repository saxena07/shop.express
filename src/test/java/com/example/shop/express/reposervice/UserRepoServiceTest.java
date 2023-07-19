package com.example.shop.express.reposervice;

import com.example.shop.express.entity.User;
import com.example.shop.express.repository.UserRepository;
import com.example.shop.express.util.UserUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class UserRepoServiceTest {


    @InjectMocks
    private UserRepoService userRepoService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {

        User user= UserUtil.getUser();
        Mockito.doReturn(user).when(userRepoService).createUser(user);
        User actualResponse = userRepoService.createUser(user);
        Assert.assertEquals(user,actualResponse);

    }
}
