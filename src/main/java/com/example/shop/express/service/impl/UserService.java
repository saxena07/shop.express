package com.example.shop.express.service.impl;

import com.example.shop.express.entity.User;
import com.example.shop.express.mapper.UserMapper;
import com.example.shop.express.model.request.user.UserCreateRequest;
import com.example.shop.express.model.request.user.UserDetailsRequest;
import com.example.shop.express.model.request.user.UserUpdateRequest;
import com.example.shop.express.model.response.user.UserCreateResponse;
import com.example.shop.express.model.response.user.UserDetailResponse;
import com.example.shop.express.reposervice.UserRepoService;
import com.example.shop.express.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {


   // private final UserMapper userMapper = UserMapper.INSTANCE;


    @Autowired
    private UserMapper userMapper;


    @Autowired
    private UserRepoService userRepoService;

    @Override
    public UserCreateResponse createUser(UserCreateRequest userCreateRequest) {
        return userMapper.mapUserResponse(userRepoService.createUser(
                userMapper.mapUser(userCreateRequest)));

    }

    @Override
    public UserDetailResponse getUserDetails(final Integer id) {
        return userMapper.mapUserDetailsResponse(userRepoService.getDetails(id));
    }

    @Override
    public UserDetailResponse getUserDetails(UserDetailsRequest userDetailsRequest) {

        return userMapper.mapUserDetailsResponse(userRepoService.getDetails(userDetailsRequest));
    }

    @Override
    public UserDetailResponse updateDetails(UserUpdateRequest userUpdateRequest) {

        User oldUser=userRepoService.getDetails(userUpdateRequest.getId());
        User updatedUser=userMapper.mapUser(userUpdateRequest,oldUser);
        return userMapper.mapUserDetailsResponse(userRepoService.createUser(updatedUser));
    }


}
