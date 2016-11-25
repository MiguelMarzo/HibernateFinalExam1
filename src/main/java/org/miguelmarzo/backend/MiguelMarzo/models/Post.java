package org.miguelmarzo.backend.MiguelMarzo.models;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Post {
	private Long id;
	private String title;
	private String content;
	private Date postDate;
	private List<Comment> comments = new ArrayList<Comment>();

	public Post() {

	}

	public Post(Long id, String title, String content, Date postDate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.postDate = postDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", postDate=" + postDate + ", comments="
				+ comments + "]";
	}

}
