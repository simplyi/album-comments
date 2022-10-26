package com.appsdeveloperblog.photoalbums.comments.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amazonaws.xray.spring.aop.XRayEnabled;

@Repository
@XRayEnabled
public interface AlbumCommentsRepository extends CrudRepository<AlbumCommentsEntity, Long> {
	
	AlbumCommentsEntity findByComment(String comment);
	List<AlbumCommentsEntity> findByAlbumId(String albumId);

}
