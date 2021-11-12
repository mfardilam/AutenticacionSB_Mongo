package com.example.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//Guia : https://www.youtube.com/watch?v=XpMXAxDN7mY 

@Document(collection = "usuarios")//para usarlo en MongoDB
public class UserModel {
	
	@Id
	private String id;
	
	private String username;
	
	private String pass;

	public UserModel() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

}
