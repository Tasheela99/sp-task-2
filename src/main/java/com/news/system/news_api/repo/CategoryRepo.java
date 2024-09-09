package com.news.system.news_api.repo;

import com.news.system.news_api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,String> {
}
