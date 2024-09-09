package com.news.system.news_api.controller;

import com.news.system.news_api.dto.RequestCategoryDto;
import com.news.system.news_api.entity.Category;
import com.news.system.news_api.service.CategoryService;
import com.news.system.news_api.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
@CrossOrigin
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<StandardResponse> create(@RequestBody RequestCategoryDto dto) {
        categoryService.createCategory(dto);
        return new ResponseEntity<>(
                new StandardResponse(
                        201,
                        "Category Created",
                        null
                ), HttpStatus.CREATED
        );
    }
}
