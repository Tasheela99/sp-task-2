package com.news.system.news_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestNewsDto {

    private String title;
    private String content;
    private String categoryPropertyId;
}
