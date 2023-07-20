package com.example.shop.express.controller;

import com.example.shop.express.model.request.contactDetail.ContactDetailUpdateRequest;
import com.example.shop.express.model.response.contactDetail.ContactDetailResponse;
import com.example.shop.express.model.request.contactDetail.ContactDetailRequest;
import com.example.shop.express.service.IContactDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/contact_detail")
public class ContactDetailController {

    @Autowired
    private IContactDetailService contactDetailService;

    /***
     *
     * @param contactDetailRequest
     * It takes ...
     * @return contactDetailResponse
     */
    @PostMapping ()
    public ContactDetailResponse createContact(@Valid @RequestBody final
                                              ContactDetailRequest contactDetailRequest) {
        return contactDetailService.createContactDetails(contactDetailRequest);
    }

    /***
     *
     * @param id
     * It takes Contact Id as a Input
     * @return contactDetailResponse
     */
    @GetMapping(value = "/{id}")
    public ContactDetailResponse fetchContact(@PathVariable(value = "id") final Integer id)
    {
        return contactDetailService.fetchContactDetail(id);
    }
//
//    @GetMapping(value = "/fetch")
//    public ContactDetailResponse fetchContactDetail(@RequestParam(value ="user_id",required = false ) final Integer id,
//                                              @RequestParam(value ="phone_number",
//                                                      required = false ) final String phoneNumber,
//                                              @RequestParam(value ="address",required = false ) final String address,
//                                              @RequestParam(value ="state",required = false ) final String state,
//                                              @RequestParam(value ="city",required = false ) final String city,
//                                              @RequestParam(value = "country",required = false) final String country,
//                                              @RequestParam(value = "zip_code",required = false) final String zip_code) {
//        ContactDetailRequest contactDetailRequest=
//                ContactDetailRequest.builder().userId(id).zipCode(zip_code).address(address).state(state).phoneNumber(phoneNumber).city(city).country(country).build();
//        return contactDetailService.fetchContactDetail(contactDetailRequest);
//
//    }

    @PutMapping()
    public  ContactDetailResponse updateContact(@Valid @RequestBody final
                                                ContactDetailUpdateRequest contactDetailUpdateRequest)
    {
        return contactDetailService.updateContactDetails(contactDetailUpdateRequest);
    }


}
