package com.mycmad.schema;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Token {
	
	@Id
	private int userId;
	private StringBuffer token;
	//@OneToOne(cascade=CascadeType.ALL)
	public Token() {
		// TODO Auto-generated constructor stub
	}

}
