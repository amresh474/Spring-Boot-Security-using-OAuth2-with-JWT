package com.example.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sso.Dto.JWTAuthDto;
import com.example.sso.Dto.LoginDto;
import com.example.sso.Dto.UserDto;
import com.example.sso.securityConfig.JwtTokenProvider;
import com.example.sso.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	// POST store the user in DB
	@PostMapping("/register")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto user = null;
		try {
			user = userService.createUser(userDto);
			if (user == null) {
				return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	// POST login user
	@PostMapping("/login")
	public ResponseEntity<JWTAuthDto> loginUSer(@RequestBody LoginDto lonDto) {
		org.springframework.security.core.Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(lonDto.getEmail(), lonDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		// get the token
		String token = jwtTokenProvider.generateToken(authentication);
		JWTAuthDto jwtAuthDto = new JWTAuthDto();
		jwtAuthDto.setToken(token);
		jwtAuthDto.setEmail(authentication.getName());
		return new ResponseEntity<>(jwtAuthDto, HttpStatus.OK);
	}

}
