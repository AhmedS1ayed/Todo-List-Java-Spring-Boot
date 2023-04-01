package com.example.todolist.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class appController
{
    @GetMapping("Welcome")
    public String WelcomePage(ModelMap modelMap,String name)
    {
        modelMap.put("name",getLoggedInUsername());
        return "Welcome";
    }
    @RequestMapping("/")
    public String FirstPage()
    {
        return "redirect:Welcome";
    }

    private String getLoggedInUsername()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}