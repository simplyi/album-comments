package com.appsdeveloperblog.photoalbums.comments.service;

import java.util.List;

import com.appsdeveloperblog.photoalbums.comments.io.model.Comment;

public interface CommentsService {
   public List<Comment> getComments(String albumId);
}
