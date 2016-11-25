package org.miguelmarzo.backend.MiguelMarzo.dao;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.miguelmarzo.backend.MiguelMarzo.HibernateSession;
import org.miguelmarzo.backend.MiguelMarzo.models.Post;

public class PostDAO implements PostDAOInterface {

	
	
	@SuppressWarnings("unchecked")
	public List<Post> selectByTitle(String title) throws HibernateException {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    
		List<Post> posts = null;
		try {
			session = HibernateSession.getSession();
			
			posts = session
					.createCriteria(Post.class)
					.setFetchMode("Comment", FetchMode.JOIN)
					.add(Restrictions.like("title", "%"+title+"%"))
							.list();
		}  catch (HibernateException he) {
			he.printStackTrace();
			//handleException(he);
		} finally {
			//session.close();
		}
		return posts;
	}

	
	/* 
	 * selects one post by Id
	 * @param id
	 * @return post
	 */
	public Post selectById(Long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Post post = (Post) session.get(Post.class, id);
	    
	    session.close();
	    return post;
	}

	/*
	 * retrieves all persons from db
	 * @return List of persons
	 */
	public List<Post> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Post> posts = session.createQuery("from Post").list();
	    
	    session.close();
	    return posts;
	}

	/*
	 * inserts a new post in database
	 * @param new post
	 */
	public void insert(Post post) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.merge(post);    
	    
	    session.getTransaction().commit();	         
	    session.close();

	}

	/*
	 * updates post
	 * @param post to update
	 */
	public void update(Post post) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();	 
		    session.beginTransaction();
		 
		    session.merge(post); 
		    
		    session.getTransaction().commit();		 
		    session.close();
	}

	/*
	 * delete given post
	 * @param post to delete
	 */
	public void delete(Post post) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();	    
	    session.beginTransaction();
	    
	    session.delete(post);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}
