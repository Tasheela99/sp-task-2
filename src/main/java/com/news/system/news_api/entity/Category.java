package com.news.system.news_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "property_id",length = 80)
    private String propertyId;

    @Column(name = "category",length = 100)
    private String category;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at",columnDefinition = "DATETIME")
    private Date createAt;

    @OneToMany(mappedBy = "category")
    private Set<News> news;

}
