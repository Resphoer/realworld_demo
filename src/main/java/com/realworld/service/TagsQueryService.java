package com.realworld.service;

import com.realworld.mapper.article.TagReadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TagsQueryService {
    private TagReadService tagReadService;

    public List<String> allTags(){
        return tagReadService.all();
    }
}
