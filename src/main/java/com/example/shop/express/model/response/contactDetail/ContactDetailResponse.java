package com.example.shop.express.model.response.contactDetail;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ContactDetailResponse {

    private Integer id;

    private Integer userId;

    private Long createdAt;

    private String phoneNumber;


    private String address;


    private String state;


    private String city;


    private String country;


    private String zipCode;

    private Boolean isDefault;

}
