package com.myapp.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Controller
public class MainController {
    HashMap<String,String> source = new HashMap<>();
    @RequestMapping("/signup")
    String toSignUpPage() {
        return "signup";
    }

    @RequestMapping("/signuping")
    public String toSignUpingPage(HttpServletRequest request){
        String usr = request.getParameter("usr");
        String pwd = request.getParameter("pwd");
        if(source.containsKey(usr));
        else{
            source.put(usr,pwd);
        }
        return "signup";
    }
    @RequestMapping("/login")
    String toLoginPage() {
        return "login";
    }
    @RequestMapping("/logging")
    String toProcessingPage(HttpServletRequest request, Model model) {
        String usr = request.getParameter("usr");
        String pwd = request.getParameter("pwd");
        if(!(source.containsKey(usr)));
        else if(source.get(usr).equals(pwd)){
            model.addAttribute("User", usr);
            return "welcome";
        }
        return "error";
    }


}
