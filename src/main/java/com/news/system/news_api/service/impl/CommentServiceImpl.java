package com.news.system.news_api.service.impl;

import com.news.system.news_api.dto.RequestCommentDto;
import com.news.system.news_api.entity.Comment;
import com.news.system.news_api.entity.News;
import com.news.system.news_api.entity.Reader;
import com.news.system.news_api.repo.CommentRepo;
import com.news.system.news_api.repo.NewsRepo;
import com.news.system.news_api.repo.ReaderRepo;
import com.news.system.news_api.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepo commentRepo;
    private final ReaderRepo readerRepo;
    private final NewsRepo newsRepo;


    @Override
    @Transactional
    public void createComment(RequestCommentDto dto) {
        Optional<Reader> readerOptional = readerRepo.findById(dto.getReader());
        Optional<News> newsOptional = newsRepo.findById(dto.getNews());

        Reader reader = readerOptional.get();
        News news = newsOptional.get();

        Comment comment = Comment.builder()
                .propertyId(UUID.randomUUID().toString())
                .createAt(new Date())
                .comment(dto.getComment())
                .readers(reader)
                .news(news)
                .build();
        commentRepo.save(comment);
        newsOptional.get().setComment(comment);
        newsRepo.save(newsOptional.get());
    }
}
