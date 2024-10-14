package com.webapp.springboot.TodoWebApp.Repository;

import com.webapp.springboot.TodoWebApp.Todo.TodoLogic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoLogic,Integer>
{
    public List<TodoLogic> findByusername(String username);
}
