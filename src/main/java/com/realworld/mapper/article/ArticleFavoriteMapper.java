package com.realworld.mapper.article;

import com.realworld.entity.favorite.ArticleFavorite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface ArticleFavoriteMapper {

    ArticleFavorite find(@Param("articleId") String articleId, @Param("userId") String userId);

    void insert(@Param("articleFavorite") ArticleFavorite articleFavorite);

    void delete(@Param("favorite") ArticleFavorite favorite);
}
