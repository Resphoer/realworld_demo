package com.realworld.repository;

import com.realworld.entity.comment.Comment;
import com.realworld.entity.comment.CommentRepository;
import com.realworld.mapper.comment.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MyBatisCommentRepository implements CommentRepository {
    private final CommentMapper commentMapper;

    @Autowired
    public MyBatisCommentRepository(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public void save(Comment comment) {
        commentMapper.insert(comment);
    }

    @Override
    public Optional<Comment> findById(String articleId, String id) {
        return Optional.ofNullable(commentMapper.findById(articleId, id));
    }

    @Override
    public void remove(Comment comment) {
        commentMapper.delete(comment.getId());
    }
}
