package com.example.shop.express.mapper;

import com.example.shop.express.entity.User;
import com.example.shop.express.model.request.UserCreateRequest;
import com.example.shop.express.model.response.UserCreateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserRequest(UserCreateRequest userCreateRequest);


    UserCreateResponse mapUserResponse(User user);
}
