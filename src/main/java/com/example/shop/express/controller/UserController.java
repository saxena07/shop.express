package com.example.shop.express.controller;

import com.example.shop.express.model.request.UserCreateRequest;
import com.example.shop.express.model.response.UserCreateResponse;
import com.example.shop.express.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/create")
    public UserCreateResponse create(
            @RequestBody @Valid final UserCreateRequest userCreateRequest) {
        return userService.createUser(userCreateRequest);

    }


}
