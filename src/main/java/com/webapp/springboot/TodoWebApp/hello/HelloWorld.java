package com.webapp.springboot.TodoWebApp.hello;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class HelloWorld
{
    // simple url
    // replies as


    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
       return " Hello! What are you learning today";

    }


    @RequestMapping("/html")
    @ResponseBody
    public String sayHelloHTML(){

        StringBuilder sb = new StringBuilder();

        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My first Html page</title>");
        sb.append("</head");
        sb.append("<body>");
        sb.append("<b>:) hi what are you doing</b>");
        sb.append("</body>");

        sb.append("</html>");

        return sb.toString();
    };


    // JSP

    @RequestMapping("/Rjsp")

    public String sayHelloJSP(){
        return "helloworld";

    }
}
