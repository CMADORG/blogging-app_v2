package com.mycmad.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mycmad.api.User;
import com.mycmad.blogexceptions.DuplicateUserException;
import com.mycmad.blogexceptions.InvalidParameterException;
import com.mycmad.blogexceptions.InvalidUserException;
import com.mycmad.schema.UserSchema;
import com.mycmad.utility.MD5Utility;

public class JPAUserDAO implements UserDAO {
	
	private EntityManagerFactory emf = MyPersistanceManager.getInstance(); 

	public void printfemf()
	{
		System.out.println("JPABlogDAO.printfemf() emf= " +emf);
	}
	
	public JPAUserDAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean addUser(UserSchema u) throws DuplicateUserException{
		EntityManager em = emf.createEntityManager();
		//em.find(UserSchema.class,10);
		em.getTransaction().begin();
		
		Query q = em.createQuery("SELECT v FROM UserSchema v where v.userName=" +"\'" +u.getUserName() +"\'");
		
		List<UserSchema> s = q.getResultList();
				 
		try{
			if( s.size() == 0)
			{
				em.persist(u);
			}
			else
			{
				throw new DuplicateUserException("User already exists");
			}
		}
		finally{
			em.getTransaction().commit();
			em.close();
		}	
		return true;
	}

	public UserSchema findUser(String u) throws InvalidUserException {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query q = em.createQuery("SELECT v FROM UserSchema v where v.userName=" +"\'" +u +"\'");
		
		
		List<UserSchema> user_data = q.getResultList();
        
		
        if(user_data.size() == 0)
		{
			throw new InvalidUserException();
		}
		
		System.out.println("JPAUserDAO.findUser()" +user_data.get(0).getUserId());
	     em.getTransaction().commit();
		em.close();
		return user_data.get(0);

		
	}

	@Override
	public String loginUser(User u) throws InvalidUserException {

		EntityManager em = emf.createEntityManager();
		String token = null;
		em.getTransaction().begin();
//		Query q = em.createQuery("SELECT u FROM UserSchema u WHERE u.userName LIKE " +u);
		Query q = em.createQuery("SELECT v FROM UserSchema v where v.userName=" +"\'" +u.getUserName() +"\'");
		//Query q = em.createQuery("SELECT u FROM UserSchema u ");
		List<UserSchema> user_data = q.getResultList();
        String apiUserPassword = MD5Utility.generatePasswordHash(u.getPassword());
		
        if(user_data.size() == 0)
		{
			throw new InvalidUserException();
		}
		else if(user_data.get(0).getUserName().compareTo(u.getUserName()) == 0 &&
				user_data.get(0).getPasswordHash().compareTo(apiUserPassword) == 0)
		{
			//process for login and return the token
			 token = MD5Utility.generatePasswordHash(user_data.get(0).getUserName());
		    user_data.get(0).setToken(token);
		    em.persist(user_data.get(0));
		    
		}
		else
		{
			throw new InvalidUserException();
		}
			
		
	    em.getTransaction().commit();
		em.close();
//		return s.get(0).getUserId();

		
		return token;
	}
	
	@Override
	public void logoutUser(User u) throws InvalidUserException {

		EntityManager em = emf.createEntityManager();
		String token = null;
		em.getTransaction().begin();
//		Query q = em.createQuery("SELECT u FROM UserSchema u WHERE u.userName LIKE " +u);
		Query q = em.createQuery("SELECT v FROM UserSchema v where v.userName=" +"\'" +u.getUserName() +"\'");
		//Query q = em.createQuery("SELECT u FROM UserSchema u ");
		List<UserSchema> user_data = q.getResultList();
        //String apiUserPassword = MD5Utility.generatePasswordHash(u.getPassword());
		
        if(user_data.size() == 0)
		{
        	em.getTransaction().commit();
    		em.close();
			throw new InvalidUserException();
		}
		else {
			//process for login and return the token
			// token = MD5Utility.generatePasswordHash(user_data.get(0).getUserName());
		    user_data.get(0).setToken(null);
		    em.persist(user_data.get(0));
		    
		}
			
		
	    em.getTransaction().commit();
		em.close();
//		return s.get(0).getUserId();
		
	//	return token;
	}

	@Override
	public UserSchema validateUserLogin(User u) throws InvalidUserException {
		
		EntityManager em = emf.createEntityManager();
		String token = null;
		em.getTransaction().begin();
//		Query q = em.createQuery("SELECT u FROM UserSchema u WHERE u.userName LIKE " +u);
		Query q = em.createQuery("SELECT v FROM UserSchema v where v.userName=" +"\'" +u.getUserName() +"\'");
		//Query q = em.createQuery("SELECT u FROM UserSchema u ");
		List<UserSchema> user_data = q.getResultList();
     //   String apiUserPassword = MD5Utility.generatePasswordHash(u.getPassword());
		
        if(user_data.size() == 0 || (user_data.get(0).getUserName().compareTo(u.getUserName()) != 0 ||
        		(user_data.get(0).getToken() != null 
        		&& user_data.get(0).getToken().compareTo(u.getToken()) != 0)))
		{
			
		    em.getTransaction().commit();
			em.close();
			throw new InvalidUserException();
		}
	
	    em.getTransaction().commit();
		em.close();
//		return s.get(0).getUserId();
	
		return user_data.get(0);
	}
	
	

}
