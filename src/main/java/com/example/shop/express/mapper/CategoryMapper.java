package com.example.shop.express.mapper;

import com.example.shop.express.entity.Category;
import com.example.shop.express.model.request.category.AddCategoryRequest;
import com.example.shop.express.model.response.category.AddCategoryResponse;
import com.example.shop.express.model.response.category.FetchCategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category mapCategoryRequest(final AddCategoryRequest addCategoryRequest);

    AddCategoryResponse mapCategoryEntity(final Category category);

    FetchCategoryResponse mapFetchedCategory(final Category category);

    List<FetchCategoryResponse> mapFetchedCategories(final List<Category> categories);
}
