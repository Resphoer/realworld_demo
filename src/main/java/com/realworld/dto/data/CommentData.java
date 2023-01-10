package com.realworld.dto.data;

import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.realworld.dto.Node;
import com.realworld.dto.PageCursor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentData implements Node {
    private String id;
    private String body;
    @JsonIgnore
    private String articleId;
    private DateTime createdAt;
    private DateTime updatedAt;

    @JsonProperty("author")
    private ProfileData profileData;

    @Override
    public PageCursor getCursor() {
        return null;
    }
}
