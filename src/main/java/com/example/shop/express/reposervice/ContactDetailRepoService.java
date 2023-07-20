package com.example.shop.express.reposervice;

import com.example.shop.express.entity.ContactDetail;
import com.example.shop.express.repository.ContactDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactDetailRepoService {

    private ContactDetailRepository contactDetailRepository;

    public ContactDetail createContact(final ContactDetail contactDetail) {
        return contactDetailRepository.save(contactDetail);

    }

    public ContactDetail fetchContact(final Integer id) {
        return contactDetailRepository.getReferenceById(id);
    }
    public ContactDetail fetchContact(final ContactDetail contactDetail) {
        return contactDetailRepository.getReferenceById(contactDetail.getId());
    }
}
