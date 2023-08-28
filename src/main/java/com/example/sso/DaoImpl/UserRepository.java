package com.example.sso.DaoImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sso.Entity.Users;


public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByEmail(String email);

}
