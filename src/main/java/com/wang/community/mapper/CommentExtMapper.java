package com.wang.community.mapper;

import com.wang.community.model.Comment;

public interface CommentExtMapper {

    int incCommentCount(Comment comment);
}