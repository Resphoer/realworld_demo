package com.realworld.entity.article;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "name")
public class Tag {
    private String id;
    private String name;

    public Tag(String name){
        this.id = UUID.randomUUID().toString(); //生成唯一标识符
        this.name = name;
    }
}
