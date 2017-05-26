package com.mycmad.data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyPersistanceManager {

	private static EntityManagerFactory emf = null;
	
	
	public static EntityManagerFactory getInstance()
	{
		if(emf == null)
		emf = Persistence.createEntityManagerFactory("com.myblogger.blog");
		return emf;
	}
}
