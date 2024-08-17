package com.in28minutes.rest.webservices.restfulwebservices.todo;

import com.in28minutes.rest.webservices.restfulwebservices.todo.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoJpaResource {

    private TodoService todoService;

    private TodoRepository todoRepository;

    public TodoJpaResource(TodoService todoService, TodoRepository todoRepository) {
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username) {
        //return todoService.findByUsername(username);
        return todoRepository.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo retrieveTodo(@PathVariable String username,
                             @PathVariable Integer id) {
        //return todoService.findById(id);
        //Optional, so use get()
        return todoRepository.findById(id).get();
    }

    @PostMapping("/users/{username}/todos")
    public Todo createTodo(@PathVariable String username,
                           @RequestBody Todo todo) {
        todo.setUsername(username);
        todo.setId(null);
        return todoRepository.save(todo);
//        Todo createdTodo = todoService.addTodo(username, todo.getDescription(),
//                todo.getTargetDate(),todo.isDone() );
//
//        return createdTodo;
    }

    @PutMapping("/users/{username}/todos/{id}")
    public Todo updateTodo(@PathVariable String username,
                           @PathVariable int id, @RequestBody Todo todo) {
        //todoService.updateTodo(todo);
        todoRepository.save(todo);
        return todo;
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username,
                                           @PathVariable Integer id) {
        //todoService.deleteById(id);
        todoRepository.deleteById(id);
        //default is 200 on successful delete
        //specific response of noContent 204 will be returned
        return ResponseEntity.noContent().build();
    }

}