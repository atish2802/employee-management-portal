package com.springboot.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapi.dto.AuthResponse;
import com.springboot.restapi.dto.LoginRequest;
import com.springboot.restapi.entity.User;
import com.springboot.restapi.repository.UserRepository;
import com.springboot.restapi.security.JwtService;

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
	public AuthResponse login(@RequestBody LoginRequest request) {

		authenticationManager.authenticate(

				new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		User user = repository.findByUsername(request.getUsername()).orElseThrow();

		String token = jwtService.generateToken(user.getUsername(), user.getRole());

		return new AuthResponse(token);
	}

}