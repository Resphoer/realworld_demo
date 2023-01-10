package com.realworld.mapper.comment;

import cn.hutool.core.date.DateTime;
import com.realworld.dto.CursorPageParameter;
import com.realworld.dto.data.CommentData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentReadService {
    CommentData findById(@Param("id") String id);

    List<CommentData> findByArticleId(@Param("articleId") String articleId);

    List<CommentData> findByArticleIdWithCursor(
            @Param("articleId") String articleId, @Param("page") CursorPageParameter<DateTime> page
    );
}
