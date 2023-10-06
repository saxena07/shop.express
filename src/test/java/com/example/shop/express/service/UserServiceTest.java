package com.example.shop.express.service;

import com.example.shop.express.entity.User;
import com.example.shop.express.model.request.user.UserCreateRequest;
import com.example.shop.express.model.response.user.UserCreateResponse;
import com.example.shop.express.reposervice.UserRepoService;
import com.example.shop.express.repository.UserRepository;
import com.example.shop.express.util.UserUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private IUserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserRepoService userRepoService;

    @Test
    public void TestCreateUser() {
        UserCreateRequest userRequest = UserUtil.getUserCreateRequest();
        User user = UserUtil.getUser();
        UserCreateResponse userResponse = UserUtil.getUserCreateResponse();
//        Mockito.doReturn(Collections.emptyList()).when(userRepoService)
//        Mockito.doReturn(Collections.emptyList()).when(itemRepoService)
//                .getItemByName(Mockito.anyString());
//        Mockito.doReturn(Collections.emptyList()).when(itemRepoService)
//                .getItemByCode(Mockito.anyString());
//        Mockito.doReturn(item).when(itemRepoService).saveItem(Mockito.any());
//        ItemResponse actualResponse = itemService.createItem(itemRequest);
//        Assert.assertEquals(itemResponse, actualResponse);

        UserCreateResponse actualResponse = userService.createUser(userRequest);
        Assert.assertEquals(userResponse,actualResponse);

    }
}
