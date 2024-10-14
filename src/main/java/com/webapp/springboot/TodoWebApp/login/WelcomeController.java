package com.webapp.springboot.TodoWebApp.login;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
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
