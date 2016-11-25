package org.miguelmarzo.backend.MiguelMarzo.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.miguelmarzo.backend.MiguelMarzo.HibernateSession;
import org.miguelmarzo.backend.MiguelMarzo.models.Comment;
import org.miguelmarzo.backend.MiguelMarzo.models.Post;


public class CommentDAO implements CommentDAOInterface {

	
	
	
	@SuppressWarnings("unchecked")
	public List<Comment> selectByContent (String content) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    
		List<Comment> comments = null;
		
			session = HibernateSession.getSession();
			Query query = session
					.createQuery(
							"FROM Comment WHERE content LIKE ?");
			query.setParameter(0, "%" +content + "%");
			
			comments = query.list();
			try {
		}  catch (HibernateException he) {
			he.printStackTrace();
			//handleException(he);
		} finally {
			
		}
		
		return comments;
	}
	/* 
	 * selects one Comment by Id
	 * @param id
	 * @return Comment
	 */
	public Comment selectById(Long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Comment comment = (Comment) session.get(Comment.class, id);
	    
	    session.close();
	    return comment;
	}

	/*
	 * retrieves all comments from db
	 * @return List of comments
	 */
	public List<Comment> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Comment> comments = session.createQuery("from Comment").list();
	    
	    session.close();
	    return comments;
	}

	/*
	 * inserts a new comment in database
	 * retrieves generated id and sets to comment instance
	 * @param new comment
	 */
	public void insert(Comment comment) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	
	    session.persist(comment);
	         
	    session.getTransaction().commit();
	    session.close();

	}

	/*
	 * updates comment
	 * @param comment to update
	 */
	public void update(Comment comment) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();	 
		    session.beginTransaction();
		 
		    session.merge(comment);
		 
		    session.getTransaction().commit();
		    session.close();
	}

	/*
	 * delete given comment
	 * @param comment to delete
	 */
	public void delete(Comment comment) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();	    
	    session.beginTransaction();
	    
	    session.delete(comment);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}
