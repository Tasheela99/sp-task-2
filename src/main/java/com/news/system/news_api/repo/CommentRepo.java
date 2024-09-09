package com.news.system.news_api.repo;

import com.news.system.news_api.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,String> {
}
