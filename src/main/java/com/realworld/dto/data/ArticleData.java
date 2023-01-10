package com.realworld.dto.data;

import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.realworld.dto.Node;
import com.realworld.dto.PageCursor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleData implements Node {
    private String id;
    private String slug;
    private String title;
    private String description;
    private String body;
    private boolean favorited;
    private int favoritesCount;
    private DateTime createdAt;
    private DateTime updatedAt;
    private List<String> tagList;

    @JsonProperty("author")
    private ProfileData profileData;
    @Override
    public PageCursor getCursor() {
        return null;
    }
}
