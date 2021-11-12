package com.example.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.model.AutenticationRequest;
import com.example.mongo.model.AutenticationResponse;
import com.example.mongo.model.UserModel;
import com.example.mongo.model.UserRepository;

@RestController
public class AuthController {
	
	@Autowired
	private UserRepository repositorio;
	
	@Autowired
	private AuthenticationManager auManager;
	
	@PostMapping("/subs")
	private ResponseEntity<?> suscripcionC(@RequestBody AutenticationRequest auten){
		String user = auten.getUsername();
		String pass = auten.getPass();
		UserModel userM = new UserModel();
		userM.setUsername(user);
		userM.setPass(pass);
		try {
			repositorio.save(userM);
		}catch(Exception e) {
			return ResponseEntity.ok(new AutenticationResponse("Error con la suscripción de "+ user));
		}
		
		return ResponseEntity.ok(new AutenticationResponse("Suscripción exitosa de "+ user));	
		
	}
	
	@PostMapping("/auth")
	private ResponseEntity<?> autenticacionC(@RequestBody AutenticationRequest auten){
		String user = auten.getUsername();
		String pass = auten.getPass();
		try {
			auManager.authenticate(new UsernamePasswordAuthenticationToken(user, pass));
			//Autenticamos gracias a la clase del SpringSecurity jiji
		}catch(Exception e) {
			return ResponseEntity.ok(new AutenticationResponse("Fallo en la autenticación de "+ user));
			
		}		
			
		return ResponseEntity.ok(new AutenticationResponse("Autenticación exitosa para "+ user));
	}

}
