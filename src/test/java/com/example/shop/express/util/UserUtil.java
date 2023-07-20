package com.example.shop.express.util;

import com.example.shop.express.entity.User;
import com.example.shop.express.model.request.UserCreateRequest;
import com.example.shop.express.model.response.UserCreateResponse;

public class UserUtil {
    UserUtil()
    {}

    public static UserCreateRequest getUserCreateRequest()
    {
        return UserCreateRequest.builder().build();
    }

    public static User getUser() {
        return User.builder().build();
    }
    public static UserCreateResponse getUserCreateResponse()
    {
       return UserCreateResponse.builder().build();
    }
}
