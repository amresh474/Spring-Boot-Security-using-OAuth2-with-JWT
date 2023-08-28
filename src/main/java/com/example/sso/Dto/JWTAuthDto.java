package com.example.sso.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JWTAuthDto {
	private String token;
	private String tokenType = "Bearer";
	private String email;

}
