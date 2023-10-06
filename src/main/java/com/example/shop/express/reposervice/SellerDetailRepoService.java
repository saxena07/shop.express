package com.example.shop.express.reposervice;

import com.example.shop.express.entity.SellerDetail;
import com.example.shop.express.repository.SellerDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerDetailRepoService {

    @Autowired
    private SellerDetailRepository sellerDetailRepository;

    public SellerDetail saveSellerDetail(final SellerDetail sellerDetail) {
        return sellerDetailRepository.save(sellerDetail);
    }

    public SellerDetail fetchSellerDetail(final Integer id) {
        return sellerDetailRepository.getReferenceById(id);
    }
}
