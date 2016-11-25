package org.miguelmarzo.backend.MiguelMarzo.dao;

import java.util.List;
import org.miguelmarzo.backend.MiguelMarzo.models.Comment;

public interface CommentDAOInterface {
	
	public Comment selectById(Long id);
	public List<Comment> selectAll ();
	public void insert (Comment comment);
	public void update (Comment comment);
	public void delete (Comment comment);

}
