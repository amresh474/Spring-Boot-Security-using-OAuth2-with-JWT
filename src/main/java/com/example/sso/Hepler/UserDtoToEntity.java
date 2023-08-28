package com.example.sso.Hepler;

import org.springframework.stereotype.Component;

import com.example.sso.Dto.UserDto;
import com.example.sso.Entity.Users;

@Component
public class UserDtoToEntity {

	public Users userDtoToEntity(UserDto userDto) {
		Users users = new Users();
		users.setName(userDto.getName());
		users.setEmail(userDto.getEmail());
		users.setPassword(userDto.getPassword());
		return users;

	}

	public UserDto userEntityToUserDto(Users users) {
		UserDto userDto = new UserDto();
		userDto.setId(users.getId());
		userDto.setEmail(users.getEmail());
		userDto.setName(users.getName());
		userDto.setPassword(users.getPassword());
		return userDto;

	}

}
