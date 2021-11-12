package com.example.mongo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.mongo.model.UserModel;
import com.example.mongo.model.UserRepository;

@Service
public class UserService implements UserDetailsService{
	//Clase de Spring Security
	
	@Autowired
	private UserRepository repositorio;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel usuarioEncontrado = repositorio.findByUsername(username);
		if(usuarioEncontrado == null) return null;
	
		String name = usuarioEncontrado.getUsername();
		String pass = usuarioEncontrado.getPass();		
		
		return new User(name,pass,new ArrayList<>());
	}
	

}
