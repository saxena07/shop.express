package com.example.shop.express.service;

import com.example.shop.express.model.request.user.UserCreateRequest;
import com.example.shop.express.model.request.user.UserDetailsRequest;
import com.example.shop.express.model.request.user.UserUpdateRequest;
import com.example.shop.express.model.response.user.UserCreateResponse;
import com.example.shop.express.model.response.user.UserDetailResponse;


public interface IUserService {

    UserCreateResponse createUser(final UserCreateRequest userCreateRequest);

    UserDetailResponse getUserDetails(final Integer id);

    UserDetailResponse getUserDetails(final UserDetailsRequest userDetailsRequest);

    UserDetailResponse updateDetails(UserUpdateRequest userUpdateRequest);
}
