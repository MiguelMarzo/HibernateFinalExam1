package org.miguelmarzo.backend.MiguelMarzo.dao;

import java.util.List;
import org.miguelmarzo.backend.MiguelMarzo.models.Post;

public interface PostDAOInterface {
	
	public Post selectById(Long id);
	public List<Post> selectAll ();
	public void insert (Post post);
	public void update (Post post);
	public void delete (Post post);

}
