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


@Controller
@SessionAttributes("name")
public class TodoControllerJPA
{



    private TodoRepository todoRepository;
    public TodoControllerJPA(TodoRepository todoRepository)
    {
        super();
        this.todoRepository=todoRepository;

    }

    // Requuest mapping here
    @RequestMapping("list-todos")
    public String getList(ModelMap modelMap){
        String username =getLoggedInUsername(modelMap);





        List<TodoLogic> todos= todoRepository.findByusername(username);
        modelMap.addAttribute("todos",todos);
        return "ListToDos";
    }


    @RequestMapping( value = "add-todo" ,method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        TodoLogic todo = new TodoLogic(8,(String) model.get("name"),"",LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
        return "todo";
    }




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

    @RequestMapping(value = "delete-todo")
    public String deleteTodo(@RequestParam int id){

        todoRepository.deleteById(id);

        return "redirect:list-todos";
    }
    @RequestMapping(value = "update-todo",method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id,ModelMap map){
        TodoLogic todo= todoRepository.findById(id).get();
        map.addAttribute("todo",todo);

        return "todo";
    }


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

    private String getLoggedInUsername(ModelMap map){

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }






}
