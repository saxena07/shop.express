package com.example.shop.express.model.request.contactDetail;

import com.example.shop.express.constant.Constant;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ContactDetailUpdateRequest {

    @NotNull(message = Constant.PROVIDE_ALL_CATEGORY_DETAILS)
    private Integer Id;

    private String phoneNumber;

    private String address;

    private String state;

    private String city;

    private String country;

    private String zipCode;

    private Boolean isDefault;


}
