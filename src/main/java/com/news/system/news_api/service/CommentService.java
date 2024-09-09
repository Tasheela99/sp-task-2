package com.news.system.news_api.service;

import com.news.system.news_api.dto.RequestCommentDto;

public interface CommentService {
    void createComment(RequestCommentDto dto);
}
