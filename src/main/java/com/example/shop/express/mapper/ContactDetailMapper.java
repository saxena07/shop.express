package com.example.shop.express.mapper;

import com.example.shop.express.entity.ContactDetail;
import com.example.shop.express.model.request.contactDetail.ContactDetailUpdateRequest;
import com.example.shop.express.model.response.contactDetail.ContactDetailResponse;
import com.example.shop.express.model.request.contactDetail.ContactDetailRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContactDetailMapper {

    ContactDetailMapper INSTANCE= Mappers.getMapper(ContactDetailMapper.class);

    ContactDetail mapContactDetail(final ContactDetailRequest contactDetailRequest);


    ContactDetailResponse mapContactDetailResponse(final ContactDetail contactDetail);

    ContactDetail mapContactDetail(final ContactDetailUpdateRequest contactDetailUpdateRequest);

    ContactDetail mapContactDetail(final ContactDetail contactDetail);
}
