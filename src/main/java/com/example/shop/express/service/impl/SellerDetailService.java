package com.example.shop.express.service.impl;

import com.example.shop.express.entity.SellerDetail;
import com.example.shop.express.entity.User;
import com.example.shop.express.mapper.SellerDetailMapper;
import com.example.shop.express.model.request.sellerDetail.SellerDetailRequest;
import com.example.shop.express.model.response.sellerDetail.SellerDetailResponse;
import com.example.shop.express.reposervice.SellerDetailRepoService;
import com.example.shop.express.reposervice.UserRepoService;
import com.example.shop.express.service.ISellerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerDetailService implements ISellerDetailService
{
    @Autowired
    private SellerDetailRepoService sellerDetailRepoService;

    @Autowired
    private SellerDetailMapper sellerDetailMapper;

    @Autowired
    private UserRepoService userRepoService;

    @Override
    public SellerDetailResponse addSellerDetail(final SellerDetailRequest sellerDetailRequest) {

        Optional<User> user=
                Optional.ofNullable(userRepoService.getDetails(sellerDetailRequest.getUserId()));
        SellerDetail sellerDetail = sellerDetailMapper.mapSellerDetail(sellerDetailRequest);


        //  improve this part
        user.get().setSellerDetail(sellerDetail);
        //userRepoService.createUser(user.get());
        SellerDetailResponse sellerDetailResponse=
                sellerDetailMapper.mapSellerDetailResponse(sellerDetailRepoService.saveSellerDetail(sellerDetail));
        sellerDetailResponse.setUserId(user.get().getId());
        return sellerDetailResponse;




    }

    @Override
    public SellerDetailResponse fetchSellerDetail(final Integer id) {
        return sellerDetailMapper.mapSellerDetailResponse(sellerDetailRepoService.fetchSellerDetail(id));
    }
}
