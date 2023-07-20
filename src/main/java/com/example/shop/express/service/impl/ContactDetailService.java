package com.example.shop.express.service.impl;

import com.example.shop.express.mapper.ContactDetailMapper;
import com.example.shop.express.model.request.contactDetail.ContactDetailUpdateRequest;
import com.example.shop.express.model.request.contactDetail.ContactDetailRequest;
import com.example.shop.express.model.response.contactDetail.ContactDetailResponse;
import com.example.shop.express.reposervice.ContactDetailRepoService;
import com.example.shop.express.service.IContactDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactDetailService implements IContactDetailService {

    @Autowired
    private ContactDetailRepoService contactRepoService;

    @Autowired
    private ContactDetailMapper contactDetailMapper;


    //private final ContactMapper contactMapper=ContactMapper.INSTANCE;

    @Override
    public ContactDetailResponse createContactDetails(ContactDetailRequest contactDetailRequest) {

        return contactDetailMapper.mapContactDetailResponse(contactRepoService.createContact(
                contactDetailMapper.mapContactDetail(contactDetailRequest)));
    }

    @Override
    public ContactDetailResponse fetchContactDetail(final Integer id) {
        return contactDetailMapper.mapContactDetailResponse(contactRepoService.fetchContact(id));
    }

    @Override
    public ContactDetailResponse fetchContactDetail(
            final ContactDetailRequest contactDetailRequest) {
        return contactDetailMapper.mapContactDetailResponse(contactRepoService.fetchContact(
                contactDetailMapper.mapContactDetail(contactDetailRequest)));

    }

    @Override
    public ContactDetailResponse updateContactDetails(
            final ContactDetailUpdateRequest contactDetailUpdateRequest) {

        return contactDetailMapper.mapContactDetailResponse(contactRepoService.fetchContact(
                contactDetailMapper.mapContactDetail(contactDetailUpdateRequest)));
    }

}
