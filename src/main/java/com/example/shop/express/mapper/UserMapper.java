package com.example.shop.express.mapper;

import com.example.shop.express.entity.User;
import com.example.shop.express.model.request.user.UserCreateRequest;
import com.example.shop.express.model.request.user.UserDetailsRequest;
import com.example.shop.express.model.request.user.UserUpdateRequest;
import com.example.shop.express.model.response.user.UserCreateResponse;
import com.example.shop.express.model.response.user.UserDetailResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUser(UserCreateRequest userCreateRequest);


    UserCreateResponse mapUserResponse(User user);

    UserDetailResponse mapUserDetailsResponse(User user);

    User mapUser(UserDetailsRequest userDetailsRequest);

    User mapUser(User oldUser);

    User mapUser(final UserUpdateRequest userUpdateRequest);
}
