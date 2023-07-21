package com.example.shop.express.model.request.user;

import com.example.shop.express.constant.Constant;
import com.example.shop.express.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.apache.tomcat.util.bcel.Const;

import javax.validation.constraints.NotEmpty;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserCreateRequest {

    @NotEmpty(message = Constant.PROVIDE_USER_DETAILS)
    private String firstName;

    private String lastName;

    @NotEmpty(message = Constant.PROVIDE_USER_DETAILS)
    private String email;

    private UserType type;

    private String password;

}
