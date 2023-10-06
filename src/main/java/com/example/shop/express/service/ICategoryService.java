package com.example.shop.express.service;

import com.example.shop.express.model.request.category.AddCategoryRequest;
import com.example.shop.express.model.request.category.FetchCategoryRequest;
import com.example.shop.express.model.response.category.AddCategoryResponse;
import com.example.shop.express.model.response.category.FetchCategoryResponse;

import java.util.List;

public interface ICategoryService {

    AddCategoryResponse addCategory(AddCategoryRequest addCategoryRequest);

    FetchCategoryResponse fetchCategory(FetchCategoryRequest fetchCategoryRequest);

    List<FetchCategoryResponse> fetchCategories();
}
