package com.webapp.springboot.TodoWebApp.Repository;

import com.webapp.springboot.TodoWebApp.Todo.TodoLogic;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Transactional
@Repository

public interface TodoRepository extends JpaRepository<TodoLogic,Integer>
{
    public List<TodoLogic> findByusername(String username);
}
