package com.appsdeveloperblog.photoalbums.comments.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.appsdeveloperblog.photoalbums.comments.data.AlbumCommentsEntity;
import com.appsdeveloperblog.photoalbums.comments.data.AlbumCommentsRepository;
import com.appsdeveloperblog.photoalbums.comments.io.model.Comment;

@Service
@XRayEnabled
public class CommentsServiceImpl implements CommentsService {

	@Autowired
	AlbumCommentsRepository albumCommentsRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Comment> getComments(String albumId) {

		List<Comment> returnValue = new ArrayList<Comment>();

		Iterable<AlbumCommentsEntity> albumComments = albumCommentsRepository.findByAlbumId(albumId);
		for (AlbumCommentsEntity albumComment : albumComments) {
			try {
				returnValue.add(new Comment(albumComment.getCommentId(), albumComment.getTime(),
						albumComment.getComment() + ". On port " + InetAddress.getLocalHost().getHostAddress()));
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return returnValue;
	}

}
