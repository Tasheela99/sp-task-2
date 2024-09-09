package com.news.system.news_api.controller;

import com.news.system.news_api.dto.RequestNewsDto;
import com.news.system.news_api.service.NewsService;
import com.news.system.news_api.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/news")
@RequiredArgsConstructor
@CrossOrigin
public class NewsController {
    private final NewsService newsService;

    @PostMapping("/create")
    public ResponseEntity<StandardResponse> create(@RequestBody RequestNewsDto dto) {
        newsService.createNews(dto);
        return new ResponseEntity<>(
                new StandardResponse(
                        201,
                        "News Created",
                        null
                ), HttpStatus.CREATED
        );
    }

    @GetMapping("/get-by-category/{categoryId}")
    public ResponseEntity<StandardResponse> getByCategory(@PathVariable String categoryId) {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "News By Category",
                        newsService.getByCategory(categoryId)
                ), HttpStatus.OK
        );
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<StandardResponse> getById(@PathVariable String id) {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "News By Id",
                        newsService.getById(id)
                ), HttpStatus.OK
        );
    }

    @GetMapping("/get-all")
    public ResponseEntity<StandardResponse> getALl() {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "All News",
                        newsService.getAll()
                ), HttpStatus.OK
        );
    }
}
