package com.mycmad.schema;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Blog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="blogId")
	private int blogId;
	//@OneToOne(cascade=CascadeType.ALL)
	@ManyToOne
	private UserSchema user;
	@Column(length=4096)
	private String Blogtitle;
	private String BlogText;
	private String Tags;
	
	public int getBlogId() {
		return blogId;
	}


	public UserSchema getUser() {
		return user;
	}


	public void setUser(UserSchema user) {
		this.user = user;
	}


	public String getBlogtitle() {
		return Blogtitle;
	}


	public void setBlogtitle(String blogtitle) {
		Blogtitle = blogtitle;
	}


	public String getBlogText() {
		return BlogText;
	}


	public void setBlogText(String blogText) {
		BlogText = blogText;
	}


	public String getTags() {
		return Tags;
	}


	public void setTags(String tags) {
		Tags = tags;
	}


	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}


	

	public StringBuffer getBlogTxt() {
		return blogTxt;
	}


	public void setBlogTxt(StringBuffer blogTxt) {
		this.blogTxt = blogTxt;
	}


	private StringBuffer blogTxt; 
	//private StringBuffer[] tags;
	

	public Blog() {
		// TODO Auto-generated constructor stub
	}

}
