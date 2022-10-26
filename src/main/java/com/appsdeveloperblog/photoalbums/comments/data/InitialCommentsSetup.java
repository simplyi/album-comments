package com.appsdeveloperblog.photoalbums.comments.data;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.amazonaws.xray.spring.aop.XRayEnabled;

@Component
public class InitialCommentsSetup {
	
	@Autowired
	AlbumCommentsRepository albumCommentsRepository;
	
	@EventListener
	@Transactional
	public void onApplicationEvent(ApplicationReadyEvent event) {
		System.out.println("From Application ready event..."); 
		
		String albumId = "1";
		
		AlbumCommentsEntity commentOne = new AlbumCommentsEntity();
		commentOne.setComment("This is comment one");
		commentOne.setCommentId(UUID.randomUUID().toString());
		commentOne.setTime(String.valueOf(System.currentTimeMillis()));
		commentOne.setAlbumId(albumId);
		persistIfMissing(commentOne);
		
		AlbumCommentsEntity commentTwo = new AlbumCommentsEntity();
		commentTwo.setComment("This is comment two");
		commentTwo.setCommentId(UUID.randomUUID().toString());
		commentTwo.setTime(String.valueOf(System.currentTimeMillis()));
		commentTwo.setAlbumId(albumId);
		persistIfMissing(commentTwo);
		
	}
	
	private void persistIfMissing(AlbumCommentsEntity albumComment) {
		
		AlbumCommentsEntity albumCommentsEntity = albumCommentsRepository.findByComment(albumComment.getComment());
		if(albumCommentsEntity == null) {
			albumCommentsRepository.save(albumComment);
		}
	}

}
