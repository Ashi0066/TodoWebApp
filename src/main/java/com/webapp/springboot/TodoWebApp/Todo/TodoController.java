package com.webapp.springboot.TodoWebApp.Todo;


import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;




/*
Todo Controller to handel all the todos logic with the
* */

@SessionAttributes("name")
public class TodoController
{
    // Todo Service which holds performs the functions locally without the use of a database
    private TodoService todoService;


    // Constructor injection for the todo service
    public TodoController(TodoService todoService)
    {
        super();
        this.todoService = todoService;
    }


    // function to get todos for a specific user
    @RequestMapping("list-todos")
    public String getList(ModelMap modelMap){
        String username =(String) modelMap.get("name");
        List<TodoLogic> todos= todoService.findByUser(username);
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
        todoService.addTodo(getLoggedInUsername(model),todo.getDescription(), todo.getTargetDate(),false);

        return "redirect:list-todos";
    }

    // delete todo function
    @RequestMapping(value = "delete-todo")
    public String deleteTodo(@RequestParam int id){


        todoService.delete(id);
        return "redirect:list-todos";
    }

    // update todo function
    @RequestMapping(value = "update-todo",method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id,ModelMap map){
        TodoLogic todo= todoService.findById(id);
        map.addAttribute("todo",todo);

        return "todo";
    }



    // edit todo function
    @RequestMapping(value = "update-todo",method = RequestMethod.POST)
    public String editTodo(@Valid TodoLogic todoLogic , BindingResult result){

        if (result.hasErrors()){
            return "todo";
        }

        todoService.updateTodo(todoLogic);

        return "redirect:list-todos";


    }


    // function to get logged-in username
    private String getLoggedInUsername(ModelMap map){

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }






}
