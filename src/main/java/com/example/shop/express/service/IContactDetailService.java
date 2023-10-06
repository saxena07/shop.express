package com.example.shop.express.service;


import com.example.shop.express.model.request.contactDetail.ContactDetailUpdateRequest;
import com.example.shop.express.model.request.contactDetail.ContactDetailRequest;
import com.example.shop.express.model.response.contactDetail.ContactDetailResponse;

public interface IContactDetailService {


    ContactDetailResponse createContactDetails(final ContactDetailRequest contactDetailRequest);

    ContactDetailResponse fetchContactDetail(final Integer id);

    ContactDetailResponse updateContactDetails(final ContactDetailUpdateRequest contactDetailUpdateRequest);

    ContactDetailResponse fetchContactDetail(final ContactDetailRequest contactDetailRequest);
}
