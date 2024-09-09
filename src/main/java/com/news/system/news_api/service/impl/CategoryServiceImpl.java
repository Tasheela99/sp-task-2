package com.news.system.news_api.service.impl;

import com.news.system.news_api.dto.RequestCategoryDto;
import com.news.system.news_api.entity.Category;
import com.news.system.news_api.repo.CategoryRepo;
import com.news.system.news_api.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;

    @Override
    public void createCategory(RequestCategoryDto dto) {
        Category category = Category.builder()
                .propertyId(UUID.randomUUID().toString())
                .category(dto.getCategory())
                .createAt(new Date())
                .build();
        categoryRepo.save(category);
    }
}
