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
@Table(name = "readers")
public class Reader {
    @Id
    @Column(name = "property_id",length = 80)
    private String propertyId;

    @Column(name = "reader_name",length = 100)
    private String readerName;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at",columnDefinition = "DATETIME")
    private Date createAt;

    @OneToMany(mappedBy = "readers")
    private Set<Comment> comments;
}
