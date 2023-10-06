package com.example.shop.express.service.impl;

import com.example.shop.express.entity.Category;
import com.example.shop.express.mapper.CategoryMapper;
import com.example.shop.express.model.request.category.AddCategoryRequest;
import com.example.shop.express.model.request.category.FetchCategoryRequest;
import com.example.shop.express.model.response.category.AddCategoryResponse;
import com.example.shop.express.model.response.category.FetchCategoryResponse;
import com.example.shop.express.reposervice.CategoryRepoService;
import com.example.shop.express.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryRepoService categoryRepoService;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public AddCategoryResponse addCategory(AddCategoryRequest addCategoryRequest) {
        Category category = categoryMapper.mapCategoryRequest(addCategoryRequest);
        category = categoryRepoService.saveCategory(category);
        return categoryMapper.mapCategoryEntity(category);
    }

    @Override
    public FetchCategoryResponse fetchCategory(FetchCategoryRequest fetchCategoryRequest) {
        Category category = categoryRepoService.fetchCategory(fetchCategoryRequest.getId());
        return categoryMapper.mapFetchedCategory(category);
    }

    @Override
    public List<FetchCategoryResponse> fetchCategories() {
        List<Category> categories = categoryRepoService.fetchCategories();
        return categoryMapper.mapFetchedCategories(categories);
    }
}
