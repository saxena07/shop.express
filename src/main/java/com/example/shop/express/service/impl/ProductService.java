package com.example.shop.express.service.impl;

import com.example.shop.express.entity.Category;
import com.example.shop.express.entity.Product;
import com.example.shop.express.entity.SellerProduct;
import com.example.shop.express.mapper.ProductMapper;
import com.example.shop.express.model.request.product.AddProductRequest;
import com.example.shop.express.model.request.product.FetchProductRequest;
import com.example.shop.express.model.request.product.FetchProductsRequest;
import com.example.shop.express.model.response.product.AddProductResponse;
import com.example.shop.express.model.response.product.FetchProductResponse;
import com.example.shop.express.reposervice.CategoryRepoService;
import com.example.shop.express.reposervice.ProductRepoService;
import com.example.shop.express.reposervice.SellerProductRepoService;
import com.example.shop.express.reposervice.UserRepoService;
import com.example.shop.express.service.IProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepoService productRepoService;

    @Autowired
    CategoryRepoService categoryRepoService;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    SellerProductRepoService sellerProductRepoService;

    @Autowired
    UserRepoService userRepoService;


    @Override
    public AddProductResponse addProduct(final AddProductRequest addProductRequest) {

//        if(Boolean.TRUE.equals(sellerProductRepoService.checkSeller(addProductRequest.getUserId()))){
//            log.error("Seller not found in database");
//            throw new UnprocessableEntityException(
//                    "Seller not registered." + ex.getMessage());
//        }

        Category category = categoryRepoService.fetchCategory(addProductRequest.getCategoryId());
        Product product = productMapper.mapProductRequest(addProductRequest);
        product.setCategory(category);
        product = productRepoService.saveProduct(product);

        // set entry in seller_product table
        SellerProduct sellerProduct = SellerProduct.builder().price(addProductRequest.getPrice())
                .quantity(addProductRequest.getQuantity()).build();
        sellerProduct.setProduct(product);
//        System.out.println(productRepoService.fetchProduct(addProductRequest.getUserId()));
        sellerProduct.setUser(userRepoService.getDetails(addProductRequest.getUserId()));
        sellerProduct = sellerProductRepoService.saveSellerProduct(sellerProduct);

        return productMapper.mapProductEntity(product);
    }

    @Override
    public List<FetchProductResponse> fetchProducts(
            final FetchProductsRequest fetchProductsRequest) {
        List<Product> products = productRepoService.fetchProducts(fetchProductsRequest.getId(),
                fetchProductsRequest.getName(), fetchProductsRequest.getCategoryId());
        return productMapper.mapFetchedProductsEntity(products);
    }

    @Override
    public FetchProductResponse fetchProduct(final FetchProductRequest fetchProductRequest) {
        Product product = productRepoService.fetchProduct(fetchProductRequest.getId());
        return productMapper.mapFetchedProductEntity(product);
    }

}
