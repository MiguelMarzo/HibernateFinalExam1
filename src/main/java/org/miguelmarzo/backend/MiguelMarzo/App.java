package org.miguelmarzo.backend.MiguelMarzo;

import java.util.Date;

import org.miguelmarzo.backend.MiguelMarzo.dao.CommentDAO;
import org.miguelmarzo.backend.MiguelMarzo.dao.CommentDAOInterface;
import org.miguelmarzo.backend.MiguelMarzo.dao.PostDAO;
import org.miguelmarzo.backend.MiguelMarzo.dao.PostDAOInterface;
import org.miguelmarzo.backend.MiguelMarzo.models.Comment;
import org.miguelmarzo.backend.MiguelMarzo.models.Post;

public class App {
	public static void main(String args[]) {
		
		PostDAO postDAO = new PostDAO();
		CommentDAO commentDAO = new CommentDAO();
		
		
		Post post1 = new Post(null, "Good news", "I have failed again", new Date());
		Post post2 = new Post(null, "Bad news", "I've farted silently", new Date());
		
		Comment comment1 = new Comment(null, "Ok, LOL", new Date());
		Comment comment2 = new Comment(null, "WTF, LOL", new Date());
		Comment comment3 = new Comment(null, "Boobs brought me here", new Date());
		Comment comment4 = new Comment(null, "Rebel scum", new Date());
		
		post1.getComments().add(comment1);
		post1.getComments().add(comment2);
		post1.getComments().add(comment3);
		
		postDAO.insert(post1);
		postDAO.insert(post2);
		
		System.out.println("Show post1:\n" + post1);
		System.out.println("Find by title:\n" + postDAO.selectByTitle("Bad news"));
		System.out.println("Find by comment:\n" + commentDAO.selectByContent("LOL"));
	}
}
