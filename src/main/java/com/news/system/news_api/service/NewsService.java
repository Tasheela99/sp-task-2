package com.news.system.news_api.service;

import com.news.system.news_api.dto.RequestNewsDto;
import com.news.system.news_api.dto.ResponseNewsDto;

import java.util.List;

public interface NewsService {
    void createNews(RequestNewsDto dto);

    List<ResponseNewsDto> getByCategory(String categoryId);

    ResponseNewsDto getById(String id);

    List<ResponseNewsDto> getAll();
}
