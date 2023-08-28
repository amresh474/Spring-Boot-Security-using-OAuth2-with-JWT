package com.example.sso.DaoImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sso.Entity.Task;


public interface TaskRespository extends JpaRepository<Task, Long> {

}
