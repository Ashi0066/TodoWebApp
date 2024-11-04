package com.webapp.springboot.TodoWebApp.Todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


// todo  class


@Entity(name = "todos")
public class TodoLogic
{


    @Id
    @GeneratedValue
    private int Id;
    private String username ;
    @Size(min = 10,message = "Please enter At least 10 digits ")
    private String description;
    private LocalDate targetDate;
    private boolean done;



    // empty constructor for JPA
    public TodoLogic(){}



    public TodoLogic(int id, String username, String description, LocalDate targetDate, boolean done)
    {
        super();
        this.Id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public int getId()
    {
        return Id;
    }

    public void setId(int id)
    {
        this.Id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public LocalDate getTargetDate()
    {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate)
    {
        this.targetDate = targetDate;
    }

    public boolean getDone()
    {
        return this.done;
    }

    public void setDone(boolean done)
    {
        this.done = done;
    }

    @Override
    public String toString()
    {
        return "TodoLogic{" +
                "id=" + Id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", isDone=" + done +
                '}';
    }
}
