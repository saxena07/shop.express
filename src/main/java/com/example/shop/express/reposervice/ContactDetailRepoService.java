package com.example.shop.express.reposervice;

import com.example.shop.express.entity.ContactDetail;
import com.example.shop.express.repository.ContactDetailRepository;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactDetailRepoService {

    @Autowired
    private ContactDetailRepository contactDetailRepository;

    public ContactDetail createContactDetail(final ContactDetail contactDetail) {
        return contactDetailRepository.save(contactDetail);

    }

    @Named("getContactDetail")
    public ContactDetail fetchContactDetail(final Integer id) {
        return contactDetailRepository.getReferenceById(id);
    }
//    public ContactDetail fetchContactDetail(final ContactDetail contactDetail) {
//        return contactDetailRepository.getReferenceById(contactDetail.getId());
//    }
}
