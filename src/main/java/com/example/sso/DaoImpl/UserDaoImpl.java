package com.example.sso.DaoImpl;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sso.Dao.UserDao;
import com.example.sso.Entity.Users;

@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository userRepository;

	public Users createUser(Users user) {
		try {
			return userRepository.save(user);
		} catch (HibernateException e) {
			// TODO: handle exception
			throw (e);
		}

	}

}
