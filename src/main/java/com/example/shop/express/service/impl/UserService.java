package com.example.shop.express.service.impl;

import com.example.shop.express.mapper.UserMapper;
import com.example.shop.express.model.request.UserCreateRequest;
import com.example.shop.express.model.response.UserCreateResponse;
import com.example.shop.express.reposervice.UserRepoService;
import com.example.shop.express.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserMapper userMapper = UserMapper.INSTANCE;
    @Autowired
    private UserRepoService userRepoService;

    @Override
    public UserCreateResponse createUser(UserCreateRequest userCreateRequest) {

        userRepoService.createUser(
                userMapper.mapUserRequest(userCreateRequest));

        return userMapper.mapUserResponse(userRepoService.createUser(
                userMapper.mapUserRequest(userCreateRequest)));

    }
}
