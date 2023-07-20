package com.example.shop.express.model.request.product;

import com.example.shop.express.constant.Constant;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddProductRequest {

    @NotEmpty(message = Constant.PROVIDE_ALL_PRODUCT_DETAILS)
    private String name;

    private String description;

    @NotNull(message = Constant.PROVIDE_ALL_PRODUCT_DETAILS)
    private Integer categoryId;

}
