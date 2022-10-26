package com.appsdeveloperblog.photoalbums.comments.ui.controllers;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.appsdeveloperblog.photoalbums.comments.io.model.Comment;
import com.appsdeveloperblog.photoalbums.comments.service.CommentsService;

@RestController
@XRayEnabled
public class CommentsController {
	
	@Autowired
	CommentsService commentsService;

	@GetMapping("/albums/{albumId}/comments")
	public List<Comment> getAlbumComments(@PathVariable("albumId") String albumId) {
	
		  return commentsService.getComments(albumId);
		
		
	}

}
