package org.miguelmarzo.backend.MiguelMarzo.models;

import java.util.Date;

public class Comment {

	private Long id;
	private String content;
	private Date commentDate;
	private Post post;

	public Comment() {

	}

	public Comment(Long id, String content, Date commentDate) {
		this.id = id;
		this.content = content;
		this.commentDate = commentDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", commentDate=" + commentDate + "]";
	}

}
