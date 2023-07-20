package com.example.shop.express.reposervice;

import com.example.shop.express.entity.SellerProduct;
import com.example.shop.express.model.request.sellerProduct.SellerProductRequest;
import com.example.shop.express.repository.SellerProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class SellerProductRepoService {

    @Autowired
    SellerProductRepository sellerProductRepository;

    public SellerProduct fetchSellerProduct(final Integer id){
        return sellerProductRepository.getById(id);
    }

    public Integer fetchQuantity(final Integer id){
        return sellerProductRepository.fetchQuantity(id);
    }

    public void updateQuantity(final Integer id, final Integer quantity){
        sellerProductRepository.updateQuantity(id, quantity);
    }

    public SellerProduct saveSellerProduct(final SellerProduct sellerProduct) {
        return sellerProductRepository.save(sellerProduct);
    }
}
