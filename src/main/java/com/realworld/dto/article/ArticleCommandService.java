package com.realworld.dto.article;

import com.realworld.entity.article.Article;
import com.realworld.entity.article.ArticleRepository;
import com.realworld.entity.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
@AllArgsConstructor
public class ArticleCommandService {
    private ArticleRepository articleRepository;

    public Article createArticle(@Valid NewArticleParam newArticleParam, User creator){
        Article article =
                new Article(
                        newArticleParam.getTitle(),
                        newArticleParam.getDescription(),
                        newArticleParam.getBody(),
                        newArticleParam.getTagList(),
                        creator.getId()
                );
        articleRepository.save(article);
        return article;
    }

    public Article updateArticle(Article article, @Valid UpdateArticleParam updateArticleParam){
        article.update(
                updateArticleParam.getTitle(),
                updateArticleParam.getDescription(),
                updateArticleParam.getBody()
        );
        articleRepository.save(article);
        return article;
    }
}
