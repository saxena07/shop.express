package com.example.shop.express.service;

import com.example.shop.express.model.request.sellerDetail.SellerDetailRequest;
import com.example.shop.express.model.response.sellerDetail.SellerDetailResponse;

public interface ISellerDetailService {
    SellerDetailResponse addSellerDetail(final SellerDetailRequest sellerDetailRequest);

    SellerDetailResponse fetchSellerDetail(final Integer id);
}
