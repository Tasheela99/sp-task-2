package com.news.system.news_api.repo;

import com.news.system.news_api.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsRepo extends JpaRepository<News,String> {

    @Query(value = "SELECT * FROM news WHERE category_property_id=?1",nativeQuery = true)
    List<News> findByCategoryId(String categoryId);

}
