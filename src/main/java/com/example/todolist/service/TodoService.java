package com.example.todolist.service;

import com.example.todolist.dao.TodoRepository;
import com.example.todolist.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService
{
    @Autowired
    private TodoRepository todoRepository;
    public List<Todo> findByName(String name)
    {
        return todoRepository.findByName(name);
    }
    public void add(String name , String description)
    {
        todoRepository.save(new Todo(name, description,false));
    }
    public void delete(int id)
    {
        todoRepository.deleteById(id);
    }
    public void update(Todo todo)
    {
        todoRepository.save(todo);
    }
    public Todo findById(int id)
    {
        return todoRepository.findById(id).get();
    }
}
