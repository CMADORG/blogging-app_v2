package com.mycmad.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mycmad.schema.Blog;

public class JPABlogDAO implements BlogDAO {

	private EntityManagerFactory emf = MyPersistanceManager.getInstance();
	
	public void printfemf()
	{
		System.out.println("JPABlogDAO.printfemf() emf= " +emf);
	}
	
	@Override
	public String[] readMyTitles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBlog(Blog blog) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		System.out.println("JPABlogDAO.addBlog() persisting start");
		try{
		em.persist(blog);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("JPABlogDAO.addBlog() persisting end");
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public Blog readBlog(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}


}
