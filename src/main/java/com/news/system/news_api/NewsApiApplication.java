package com.news.system.news_api;

import com.news.system.news_api.entity.Reader;
import com.news.system.news_api.repo.ReaderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@RequiredArgsConstructor
public class NewsApiApplication implements CommandLineRunner {

	private final ReaderRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(NewsApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Reader reader = Reader.builder()
				.propertyId("1")
				.readerName("Example Reader")
				.createAt(new Date())
				.build();
		if (!repo.existsById(reader.getPropertyId())) {
			repo.save(reader);
		}

	}
}
