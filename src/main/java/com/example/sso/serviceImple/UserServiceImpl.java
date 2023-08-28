package com.example.sso.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.sso.Dao.UserDao;
import com.example.sso.Dto.UserDto;
import com.example.sso.Entity.Users;
import com.example.sso.Hepler.UserDtoToEntity;
import com.example.sso.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserDtoToEntity userDtoToEntity;

	@Override
	public UserDto createUser(UserDto userDto) throws Exception {

		try {
			// userDto is not an entity of user
			// converted userDto to Users
			userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
			Users user = userDtoToEntity.userDtoToEntity(userDto);
			// converted user to UserDto
			user = userDao.createUser(user);
			return userDtoToEntity.userEntityToUserDto(user);
		} catch (Exception e) {
			throw (e);
		}

	}

}
