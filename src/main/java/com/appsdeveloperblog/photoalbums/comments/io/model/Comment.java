package com.appsdeveloperblog.photoalbums.comments.io.model;

public class Comment {
	
	private final String commentId;
	private final String time;
	private final String comment;
	
	public Comment(String commentId, String time, String comment) {
		super();
		this.commentId = commentId;
		this.time = time;
		this.comment = comment;
	}

	public String getCommentId() {
		return commentId;
	}

	public String getTime() {
		return time;
	}

	public String getComment() {
		return comment;
	}
	
	
	

}
