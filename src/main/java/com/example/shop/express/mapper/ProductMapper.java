package com.example.shop.express.mapper;

import com.example.shop.express.entity.Product;
import com.example.shop.express.model.request.product.AddProductRequest;
import com.example.shop.express.model.request.product.FetchProductRequest;
import com.example.shop.express.model.request.product.FetchProductsRequest;
import com.example.shop.express.model.response.product.AddProductResponse;
import com.example.shop.express.model.response.product.FetchProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product mapProductRequest(final AddProductRequest addProductRequest);

    AddProductResponse mapProductEntity(final Product product);

    List<FetchProductResponse> mapFetchedProductsEntity(final List<Product> products);

    FetchProductResponse mapFetchedProductEntity(final Product product);
}
