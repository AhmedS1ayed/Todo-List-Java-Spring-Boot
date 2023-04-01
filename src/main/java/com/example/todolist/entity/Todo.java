package com.example.todolist.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;
@Entity
public class Todo
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String name;
    @Column
    @Size(min = 3 , message = "invalid at least 10 characters")
    private String description;
    @Column
    private LocalDate Date=LocalDate.now();
    @Column
    private boolean done = false;
    public Todo(String name, String description , boolean done)
    {
        this.name = name;
        this.description = description;
        this.done = done;
    }
    public Todo()
    {

    }
    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDate(LocalDate date) {
        Date = date;
    }
    public void setDone(boolean done) {
        this.done = done;
    }


    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public LocalDate getDate() {
        return Date;
    }
    public boolean isDone() {
        return done;
    }
}
