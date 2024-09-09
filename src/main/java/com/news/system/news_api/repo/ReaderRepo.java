package com.news.system.news_api.repo;

import com.news.system.news_api.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepo extends JpaRepository<Reader,String> {
}
