package com.realworld.entity.article;

import cn.hutool.core.date.DateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.realworld.util.Util;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Article {
    private String userId;
    private String id;
    private String slug; //url 末尾有效部分，用来标识页面
    private String title;
    private String description;
    private String body;
    private List<Tag> tags;
    private DateTime createdAt;
    private DateTime updatedAt;

    public Article(String title, String description, String body, List<String> tagList, String userId) {
        this(title,description,body,tagList,userId,new DateTime());
    }


    public Article(String title, String description, String body, List<String> tagList, String userId, DateTime createdAt) {
        this.id = UUID.randomUUID().toString();
        this.slug = toSlug(title);
        this.title = title;
        this.description = description;
        this.body = body;
        //stream 将String列表转换为Tag列表
        this.tags = new HashSet<>(tagList).stream().map(Tag::new).collect(Collectors.toList());
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
    }

    public void update(String title, String description, String body){
        if(!Util.isEmpty(title)){
            this.title = title;
            this.slug = toSlug(title);
            this.updatedAt = new DateTime();
        }
        if(!Util.isEmpty(description)){
            this.description = description;
            this.updatedAt = new DateTime();
        }
        if(!Util.isEmpty(body)){
            this.body = body;
            this.updatedAt = new DateTime();
        }
    }

    public static String toSlug(String title){
        //正则表达式
        return title.toLowerCase().replaceAll("[\\&|[\\uFE30-\\uFFA0]|\\‘|\\“|\\s\\?\\,\\.]+","-");
    }
}
