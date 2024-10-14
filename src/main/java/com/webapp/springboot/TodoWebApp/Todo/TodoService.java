package com.webapp.springboot.TodoWebApp.Todo;

import jakarta.validation.Valid;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Service
public class TodoService
{

    private static List<TodoLogic> todos= new ArrayList<>();
    private static int count= 1;

    static
    {
        todos.add(new TodoLogic(count++, "Ashir", "LearnSpring", LocalDate.now().plusYears(1), false));
        todos.add(new TodoLogic(count++, "Ashir", "LearnSpring", LocalDate.now().plusYears(1), false));
        todos.add(new TodoLogic(count++, "Ashir", "LearnSpring", LocalDate.now().plusYears(1), false));
        todos.add(new TodoLogic(count++, "Ashir", "LearnSpring", LocalDate.now().plusYears(1), false));

    }

    public List<TodoLogic> findByUser(String username){
    List<TodoLogic> userTodosList= todos.stream()
              .filter(user-> user.getUsername().equals(username))
              .collect(Collectors.toList());

        return userTodosList.isEmpty()?null:userTodosList;

    }

    public void  addTodo(String name , String description , LocalDate date, boolean done){



        TodoLogic todoLogic = new TodoLogic(++count,name,description,date,done);
        todos.add(todoLogic);
    }

    public void delete(int id){

        Predicate<? super TodoLogic> predicate= todos->todos.getId()==id;


        todos.removeIf(predicate);


    }

    public void deleteTodo(int id){

        for (int i = 0; i < todos.size(); i++)
        {
            TodoLogic logic = todos.get(i);
            if (logic.getId()==id){
                todos.remove(logic);
            }


        }

    }

    public void deleteIterator(int id){
        Iterator<TodoLogic> iterator = todos.iterator();

        while (iterator.hasNext()){
            TodoLogic logic = iterator.next();
            if (logic.getId() ==id){
                iterator.remove();
            }
        }
    }

    public TodoLogic findById(int id)
    {
       return todos.stream()
               .filter(todo->todo.getId()==id)
               .findFirst()
               .orElse(null);



    }

    public void updateTodo( @Valid TodoLogic todoLogic)
    {
        delete(todoLogic.getId());
        todos.add(todoLogic);

    }
}
