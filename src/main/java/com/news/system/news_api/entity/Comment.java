package com.news.system.news_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "comments")
public class Comment {
    @Id
    @Column(name = "property_id",length = 80)
    private String propertyId;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at",columnDefinition = "DATETIME")
    private Date createAt;

    @Column(name = "comment",length = 750)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "reader_property_id", referencedColumnName = "property_id", nullable = false)
    private Reader readers;

    @ManyToOne
    @JoinColumn(name = "news_property_id", referencedColumnName = "property_id", nullable = false)
    private News news;

}
