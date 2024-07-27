package com.in28minutes.springboot.myfirstwebapplication.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "aravind", "Get AWS Certified 1",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "aravind", "Learn DevOps 1",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "aravind", "Learn Full Stack Development 1",
                LocalDate.now().plusYears(3), false));
    }

    //return todos list as a List
    //the username check should use .equals since Strings are compared
    //the lambda expression will pull the records matching the username
    //then we are returning it as a list by converting it to a stream
    public List<Todo> findByUsername(String username) {
        Predicate<? super Todo> predicate =
                todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todos.add(todo);
    }

    public void deleteByID(int id) {
        /*
        Requirement: todo.getId() == id
        Lambda expression: todo -> todo.getId() == id
        Predicate will check for each todo value
        */
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteByID(todo.getId());
        todos.add(todo);
    }
}
