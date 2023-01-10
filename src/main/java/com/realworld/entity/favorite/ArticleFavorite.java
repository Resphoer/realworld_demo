package com.realworld.entity.favorite;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ArticleFavorite {
    private String articleId;
    private String userId;

    public ArticleFavorite(String articleId, String userId) {
        this.articleId = articleId;
        this.userId = userId;
    }
}
