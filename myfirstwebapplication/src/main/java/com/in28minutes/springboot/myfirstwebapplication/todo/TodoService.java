package com.in28minutes.springboot.myfirstwebapplication.todo;

import java.time.LocalDate;
import java.util.List;

public class TodoService {
    private static List<Todo> todos;

    static {
        todos.add(new Todo(1, "in28minutes","Get AWS Certified 1",
                LocalDate.now().plusYears(1), false ));
        todos.add(new Todo(2, "in28minutes","Learn DevOps 1",
                LocalDate.now().plusYears(2), false ));
        todos.add(new Todo(3, "in28minutes","Learn Full Stack Development 1",
                LocalDate.now().plusYears(3), false ));
    }

    public List<Todo> findByUsername(String username){
        return todos;
    }
}