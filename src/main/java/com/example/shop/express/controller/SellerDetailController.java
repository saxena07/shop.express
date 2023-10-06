package com.example.shop.express.controller;

import com.example.shop.express.model.request.sellerDetail.SellerDetailRequest;
import com.example.shop.express.model.response.sellerDetail.SellerDetailResponse;
import com.example.shop.express.service.ISellerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/seller_details")
public class SellerDetailController {

    @Autowired
    private ISellerDetailService sellerDetailService;

    @PostMapping
    public SellerDetailResponse addSellerDetails(@RequestBody final
                                                 SellerDetailRequest sellerDetailRequest)
    {
        return sellerDetailService.addSellerDetail(sellerDetailRequest);

    }

    @GetMapping(value = "/{id}")
    public SellerDetailResponse fetchSellerDetail(@PathVariable final  Integer id)
    {
        return sellerDetailService.fetchSellerDetail(id);
    }
}
