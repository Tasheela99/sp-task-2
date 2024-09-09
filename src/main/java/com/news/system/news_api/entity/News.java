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
@Table(name = "news")
public class News {
    @Id
    @Column(name = "property_id",length = 80)
    private String propertyId;

    @Column(name = "title",length = 100)
    private String title;

    @Column(name = "content",length = 750)
    private String content;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at",columnDefinition = "DATETIME")
    private Date createAt;

    @ManyToOne
    @JoinColumn(name = "category_property_id", referencedColumnName = "property_id", nullable = false)
    private Category category;

    @OneToOne( cascade = CascadeType.ALL)
    private Comment comment;


}
