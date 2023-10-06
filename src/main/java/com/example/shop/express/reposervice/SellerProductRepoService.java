package com.example.shop.express.reposervice;

import com.example.shop.express.constant.Constant;
import com.example.shop.express.entity.SellerProduct;
import com.example.shop.express.exception.InvalidActionException;
import com.example.shop.express.model.request.sellerProduct.SellerProductRequest;
import com.example.shop.express.repository.SellerProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Objects;

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

    public SellerProduct updateQuantity(final Integer id, final Integer productId,
                                  final Integer quantity){
        SellerProduct sellerProduct = fetchSellerProduct(id);
        if (fetchQuantity(productId)==0) {
            throw new InvalidActionException(Constant.CANT_PLACE_ORDER);
        }
        sellerProduct.setQuantity(fetchQuantity(productId) - quantity);
        return sellerProductRepository.save(sellerProduct);
    }

    public SellerProduct saveSellerProduct(final SellerProduct sellerProduct) {
        return sellerProductRepository.save(sellerProduct);
    }
}
