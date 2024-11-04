package com.webapp.springboot.TodoWebApp.Todo;


import com.webapp.springboot.TodoWebApp.Repository.TodoRepository;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


/*
Todo controller with JPA
  */

@Controller
@SessionAttributes("name")
public class TodoControllerJPA
{


    // Todo Service which holds performs the functions using the JPA repository
    private TodoRepository todoRepository;
    public TodoControllerJPA(TodoRepository todoRepository)
    {
        super();
        this.todoRepository=todoRepository;

    }



    // function to get todos for a specific user
    @RequestMapping("list-todos")
    public String getList(ModelMap modelMap){
        String username =getLoggedInUsername(modelMap);

        List<TodoLogic> todos= todoRepository.findByusername(username);
        modelMap.addAttribute("todos",todos);
        return "ListToDos";
    }


    // get function to show todo page
    @RequestMapping( value = "add-todo" ,method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        TodoLogic todo = new TodoLogic(8,(String) model.get("name"),"",LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
        return "todo";
    }





    // post function to add todo
    @RequestMapping( value = "add-todo" ,method = RequestMethod.POST)
    public String addNewTodoPage(ModelMap model, @Valid @ModelAttribute("todo") TodoLogic todo, BindingResult result){
        if (result.hasErrors()){
            return "todo";
        }
        String username = getLoggedInUsername(model) ;
        todo.setUsername(username);
        todoRepository.save(todo);

        return "redirect:list-todos";
    }


    // delete todo function
    @RequestMapping(value = "delete-todo")
    public String deleteTodo(@RequestParam int id){

        todoRepository.deleteById(id);

        return "redirect:list-todos";
    }

    // update todo function
    @RequestMapping(value = "update-todo",method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id,ModelMap map){
        TodoLogic todo= todoRepository.findById(id).get();
        map.addAttribute("todo",todo);

        return "todo";
    }

    // edit todo function
    @RequestMapping(value = "update-todo",method = RequestMethod.POST)
    public String editTodo(ModelMap map,@Valid TodoLogic todoLogic , BindingResult result){

        if (result.hasErrors()){
            return "todo";
        }
        String username = getLoggedInUsername(map);
        todoLogic.setUsername(username);
        todoRepository.save(todoLogic);


        return "redirect:list-todos";


    }

    // function to get logged-in username
    private String getLoggedInUsername(ModelMap map){

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }






}
