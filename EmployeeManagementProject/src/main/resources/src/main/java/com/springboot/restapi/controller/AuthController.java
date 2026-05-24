package com.springboot.restapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapi.entity.User;
import com.springboot.restapi.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest request) {

	    authenticationManager.authenticate(

	            new UsernamePasswordAuthenticationToken(
	                    request.getUsername(),
	                    request.getPassword()
	            )
	    );

	    return jwtService.generateToken(
	            request.getUsername()
	    );
	}
	
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		if(repository.findByUsername(user.getUsername()).isPresent()) {
			return "Username already exists";
		}
		
		user.setPassword(encoder.encode(user.getPassword()));
		repository.save(user);
		
		return "User Registered Successfully";
	}
}
