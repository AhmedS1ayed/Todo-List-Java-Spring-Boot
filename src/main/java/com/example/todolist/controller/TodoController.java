package com.example.todolist.controller;

import com.example.todolist.dao.TodoRepository;
import com.example.todolist.entity.Todo;
import com.example.todolist.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TodoController
{
    @Autowired
    private TodoService todoService;
    @GetMapping("list-todos")
    public String goToTodoList(ModelMap modelMap)
    {
        List<Todo> todos = todoService.findByName(getLoggedInUsername());
        modelMap.put("todos" , todos);
        return "listTodos";
    }
    @GetMapping("add-todo")
    public String addTodoPage(ModelMap modelMap)
    {
        Todo todo = new Todo(getLoggedInUsername(),"",false);
        modelMap.put("todo",todo);
        return "addTodo";
    }
    @PostMapping("add-todo")
    public String addTodo(@Valid Todo todo, BindingResult result)
    {
        if(result.hasErrors() == true)
        {
            System.out.println("we are here");
            return "addTodo";
        }
        todoService.add(getLoggedInUsername(), todo.getDescription());
        return "redirect:list-todos";
    }
    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id)
    {
            todoService.delete(id);
            return "redirect:list-todos";
    }
    @GetMapping("update-todo")
    public String getUpdateTodo(@RequestParam int id,ModelMap modelMap)
    {
        Todo todo = todoService.findById(id);
        modelMap.put("todo",todo);
        return "updateTodo";
    }
    @PostMapping("update-todo")
    public String postUpdateTodo(@Valid Todo todo, BindingResult result)
    {
        if(result.hasErrors() == true)
        {
            return "updateTodo";
        }
        todo.setName(getLoggedInUsername());
        todoService.update(todo);
        return "redirect:list-todos";
    }
    private String getLoggedInUsername()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
