package com.example.shop.express.service.impl;

import com.example.shop.express.entity.SellerDetail;
import com.example.shop.express.entity.User;
import com.example.shop.express.enums.UserType;
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

        Optional<User> userOptional=
                Optional.ofNullable(userRepoService.getDetails(sellerDetailRequest.getUserId()));
        User user=userOptional.orElseThrow(null);

        if (user.getType() != UserType.SELLER)
        {
            return null;
        }
        else {

            SellerDetail sellerDetail = sellerDetailMapper.mapSellerDetail(sellerDetailRequest);

            user.setSellerDetail(sellerDetail);
            //userRepoService.createUser(userOptional.get());
            SellerDetailResponse sellerDetailResponse =
                    sellerDetailMapper.mapSellerDetailResponse(sellerDetailRepoService.saveSellerDetail(sellerDetail));
            sellerDetailResponse.setUserId(user.getId());
            return sellerDetailResponse;
        }



    }

    @Override
    public SellerDetailResponse fetchSellerDetail(final Integer id) {
        return sellerDetailMapper.mapSellerDetailResponse(sellerDetailRepoService.fetchSellerDetail(id));
    }
}
