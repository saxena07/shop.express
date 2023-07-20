package com.example.shop.express.service.impl;

import com.example.shop.express.entity.ContactDetail;
import com.example.shop.express.entity.User;
import com.example.shop.express.mapper.ContactDetailMapper;
import com.example.shop.express.model.request.contactDetail.ContactDetailRequest;
import com.example.shop.express.model.request.contactDetail.ContactDetailUpdateRequest;
import com.example.shop.express.model.response.contactDetail.ContactDetailResponse;
import com.example.shop.express.reposervice.ContactDetailRepoService;
import com.example.shop.express.reposervice.UserRepoService;
import com.example.shop.express.service.IContactDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactDetailService implements IContactDetailService {

    @Autowired
    private ContactDetailRepoService contactDetailRepoService;

    @Autowired
    private UserRepoService userRepoService;

    @Autowired
    private ContactDetailMapper contactDetailMapper;


    //private final ContactMapper contactMapper=ContactMapper.INSTANCE;

    @Override
    public ContactDetailResponse createContactDetails(ContactDetailRequest contactDetailRequest) {

        ContactDetail contactDetail = contactDetailMapper.mapContactDetail(contactDetailRequest);
        contactDetail.setUser(userRepoService.getDetails(contactDetailRequest.getUserId()));
        log.info(contactDetail.toString());

        contactDetail = contactDetailRepoService.createContactDetail(contactDetail);
        ContactDetailResponse contactDetailResponse =
                contactDetailMapper.mapContactDetailResponse(contactDetail);
        contactDetailResponse.setUserId(contactDetail.getUser().getId());

        return contactDetailResponse;
    }

    @Override
    public ContactDetailResponse fetchContactDetail(final Integer id) {
        return contactDetailMapper.mapContactDetailResponse(
                contactDetailRepoService.fetchContactDetail(id));
    }

    @Override
    public ContactDetailResponse fetchContactDetail(
            final ContactDetailRequest contactDetailRequest) {
        return contactDetailMapper.mapContactDetailResponse(
                contactDetailRepoService.fetchContactDetail(
                        contactDetailMapper.mapContactDetail(contactDetailRequest).getId()));

    }

    @Override
    public ContactDetailResponse updateContactDetails(
            final ContactDetailUpdateRequest contactDetailUpdateRequest) {

        ContactDetail oldContactDetail = contactDetailRepoService.fetchContactDetail(
                contactDetailUpdateRequest.getId());

        ContactDetail newContactDetail = contactDetailMapper.mapContactDetail(oldContactDetail);
        newContactDetail= contactDetailMapper.mapContactDetail(contactDetailUpdateRequest);

        log.info(oldContactDetail.toString());
        newContactDetail.setUser(oldContactDetail.getUser());

        return contactDetailMapper.mapContactDetailResponse(
                contactDetailRepoService.createContactDetail(newContactDetail));
    }

}
