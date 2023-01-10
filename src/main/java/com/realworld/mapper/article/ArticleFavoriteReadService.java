package com.realworld.mapper.article;

import com.realworld.dto.data.ArticleFavoriteCount;
import com.realworld.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface ArticleFavoriteReadService {
    boolean isUserFavorite(@Param("userId") String userId, @Param("articleId") String articleId);

    int articleFavoriteCount(@Param("articleId") String articleId);

    List<ArticleFavoriteCount> articlesFavoriteCount(@Param("ids") List<String> ids);

    Set<String> userFavorite(@Param("ids") List<String> ids, @Param("currentUser") User currentUser);
}
