package com.example.shop.express.model.request.contactDetail;

import com.example.shop.express.constant.Constant;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ContactDetailRequest {

    @NotNull(message = Constant.PROVIDE_ALL_CATEGORY_DETAILS)
    private Integer userId;

    @NotEmpty(message = Constant.PROVIDE_ALL_CATEGORY_DETAILS)
    private String phoneNumber;

    @NotEmpty(message = Constant.PROVIDE_ALL_CATEGORY_DETAILS)
    private String address;

    @NotEmpty(message = Constant.PROVIDE_ALL_CATEGORY_DETAILS)
    private String state;

    @NotEmpty(message = Constant.PROVIDE_ALL_CATEGORY_DETAILS)
    private String city;

    @NotEmpty(message = Constant.PROVIDE_ALL_CATEGORY_DETAILS)
    private String country;

    @NotEmpty(message = Constant.PROVIDE_ALL_CATEGORY_DETAILS)
    private String zipCode;

    private Boolean isDefault;
}
