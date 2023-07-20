package com.example.shop.express.mapper;

import com.example.shop.express.entity.SellerDetail;
import com.example.shop.express.model.request.sellerDetail.SellerDetailRequest;
import com.example.shop.express.model.response.sellerDetail.SellerDetailResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SellerDetailMapper {

    SellerDetailMapper INSTANCE = Mappers.getMapper(SellerDetailMapper.class);

    SellerDetail mapSellerDetail(final SellerDetailRequest sellerDetailRequest);


    //@Mapping(target = "userId" ,source = "sellerDetail.User.Id")
    SellerDetailResponse mapSellerDetailResponse(final SellerDetail sellerDetail);
}
