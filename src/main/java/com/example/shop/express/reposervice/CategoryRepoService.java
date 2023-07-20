package com.example.shop.express.reposervice;

import com.example.shop.express.entity.Category;
import com.example.shop.express.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryRepoService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category fetchCategory(Integer id) {
        return categoryRepository.fetchCategory(id);
    }
}
