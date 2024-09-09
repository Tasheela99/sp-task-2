package com.news.system.news_api.service.impl;

import com.news.system.news_api.dto.RequestNewsDto;
import com.news.system.news_api.dto.ResponseNewsDto;
import com.news.system.news_api.entity.Category;
import com.news.system.news_api.entity.News;
import com.news.system.news_api.repo.CategoryRepo;
import com.news.system.news_api.repo.NewsRepo;
import com.news.system.news_api.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepo newsRepo;
    private final CategoryRepo categoryRepo;

    @Override
    public void createNews(RequestNewsDto dto) {
        Optional<Category> category = categoryRepo.findById(dto.getCategoryPropertyId());
        if (category.isEmpty()){
            throw new RuntimeException("Category Not Found");
        }
        News news = News.builder()
                .propertyId(UUID.randomUUID().toString())
                .title(dto.getTitle())
                .content(dto.getContent())
                .createAt(new Date())
                .category(category.get())
                .comment(null)
                .build();
        newsRepo.save(news);
    }

    @Override
    public List<ResponseNewsDto> getByCategory(String categoryId) {
        return newsRepo.findByCategoryId(categoryId).stream().map(
                this::converter
        ).collect(Collectors.toList());
    }

    @Override
    public ResponseNewsDto getById(String id) {
        Optional<News> news = newsRepo.findById(id);
        return converter(news.get());
    }

    @Override
    public List<ResponseNewsDto> getAll() {
        return newsRepo.findAll().stream().map(
                this::converter
        ).collect(Collectors.toList());
    }


    private ResponseNewsDto converter(News news) {
        return ResponseNewsDto.builder()
                .propertyId(news.getPropertyId())
                .title(news.getTitle())
                .content(news.getContent())
                .category(news.getCategory() != null ? news.getCategory().getCategory() : null)
                .comment(news.getComment() != null ? news.getComment().getPropertyId() : null)
                .build();
    }

}
