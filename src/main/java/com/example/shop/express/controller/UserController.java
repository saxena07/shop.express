package com.example.shop.express.controller;


import com.example.shop.express.enums.UserType;
import com.example.shop.express.model.request.user.UserCreateRequest;
import com.example.shop.express.model.request.user.UserDetailsRequest;
import com.example.shop.express.model.request.user.UserUpdateRequest;
import com.example.shop.express.model.response.user.UserCreateResponse;
import com.example.shop.express.model.response.user.UserDetailResponse;
import com.example.shop.express.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping()
    public UserCreateResponse create(
            @Valid @RequestBody final UserCreateRequest userCreateRequest) {
//        userCreateRequest.setPassword("12345678");
        return userService.createUser(userCreateRequest);

    }

    @GetMapping(value = "/{id}")
    public UserDetailResponse userDetailsById(@Valid @PathVariable(value="id") final Integer id)
    {
        return userService.getUserDetails(id);
    }

//    @PostMapping(value = "/details")
//    public UserDetailResponse userDetails(@RequestBody final UserDetailsRequest userDetailsRequest)
//    {
//        return userService.getUserDetails(userDetailsRequest);
//    }

    @PutMapping()
    public UserDetailResponse updateUser(@RequestBody final UserUpdateRequest userUpdateRequest )
    {
//        return new ServiceResponse<>(new BaseMessageResponse<>(userService.updateDetails(userUpdateRequest)));
        return userService.updateDetails(userUpdateRequest);
    }
//
//    @DeleteMapping(value="/delete")
//    public
//


    @GetMapping(value = "/fetch")
    public UserDetailResponse fetchContact(@RequestParam(value ="id",required = false ) final Integer id,
                                              @RequestParam(value ="first_name",
                                                      required = false ) final String firstName,
                                              @RequestParam(value ="last_name",required = false ) final String lastName,
                                              @RequestParam(value ="email",required = false ) final String email,
                                              @RequestParam(value ="type",required = false ) final UserType type
    )
    {
        UserDetailsRequest userDetailsRequest=
                UserDetailsRequest.builder().id(id).email(email).firstName(firstName).lastName(lastName).type(type).build();
        return userService.getUserDetails(userDetailsRequest);
    }

}