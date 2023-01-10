package com.realworld.dto.article;

import com.realworld.entity.article.Article;
import com.realworld.service.ArticleQueryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DuplicatedArticleValidator implements ConstraintValidator<DuplicatedArticleConstraint, String> {
    @Autowired
    private ArticleQueryService articleQueryService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return !articleQueryService.findBySlug(Article.toSlug(value),null).isPresent();
    }
}
