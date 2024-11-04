package com.webapp.springboot.TodoWebApp.Repository;

import com.webapp.springboot.TodoWebApp.Todo.TodoLogic;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


/*
This is the JPA repository which takes the TodoLogic class and the integers as its the id field in todo logic class
 */

@Transactional
@Repository
public interface TodoRepository extends JpaRepository<TodoLogic,Integer>
{

    // This function returns the list of User todos
    public List<TodoLogic> findByusername(String username);
}
