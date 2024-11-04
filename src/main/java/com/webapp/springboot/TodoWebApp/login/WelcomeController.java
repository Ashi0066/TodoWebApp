package com.webapp.springboot.TodoWebApp.login;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController
{

    /*
    This is the welcome controller that directs user to welcome page
    */

    //logger.info("Request param is {}",name);
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap map  ){
        map.put("name",getLoggedInUsername());
        return "Welcome";
    }

    private String getLoggedInUsername(){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
