package com.example.shop.express.model.request.contactDetail;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ContactDetailRequest {

    @NonNull
    private Integer userId;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String address;

    @NonNull
    private String state;

    private String city;

    private String country;

    private String zipCode;

    private Boolean isDefault;
}
