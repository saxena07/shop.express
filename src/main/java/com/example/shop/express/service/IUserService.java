package com.example.shop.express.service;

import com.example.shop.express.model.request.UserCreateRequest;
import com.example.shop.express.model.response.UserCreateResponse;


public interface IUserService {

    UserCreateResponse createUser(final UserCreateRequest userCreateRequest);
}
