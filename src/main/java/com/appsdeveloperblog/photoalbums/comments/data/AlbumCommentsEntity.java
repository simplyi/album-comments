package com.appsdeveloperblog.photoalbums.comments.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.amazonaws.xray.spring.aop.XRayEnabled;

@Entity
@Table(name="AlbumComments")
public class AlbumCommentsEntity {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(length=36, nullable=false)
	private String commentId;
	
	@Column(length=36, nullable=false)
	private String albumId;

	@Column(length=13, nullable=false)
	private String time;
	
	@Column(length=255, nullable=false)
	private String comment;

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}
	
	
}
