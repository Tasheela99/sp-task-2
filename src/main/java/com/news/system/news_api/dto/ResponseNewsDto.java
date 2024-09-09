package com.news.system.news_api.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseNewsDto {
    private String propertyId;
    private String title;
    private String content;
    private Date createAt;
    private String category;
    private String comment;
}
