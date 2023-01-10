package com.realworld.entity.authorization;

import com.realworld.entity.article.Article;
import com.realworld.entity.comment.Comment;
import com.realworld.entity.user.User;

public class AuthorizationService {
    public static boolean canWriteArticle(User user, Article article){
        return user.getId().equals(article.getUserId());
    }

    public static boolean canWriteComment(User user, Article article, Comment comment){
        return user.getId().equals(article.getUserId()) || user.getId().equals(comment.getUserId());
    }
}
