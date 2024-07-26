package com.in28minutes.springboot.myfirstwebapplication.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
    private TodoService todoservice;

    public TodoController(TodoService todoservice) {
        this.todoservice = todoservice;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap modelMap) {
        List<Todo> todos = todoservice.findByUsername("in28minutes");
        modelMap.addAttribute("todos", todos);
        return "listTodos";
    }

    //Get call that navigates to enter the Todo
    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String username = (String) model.get("name");
        Todo todo = new Todo(0, username, " ", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    //Post call that takes the details of Todo and go to the list-todos again
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodoPage(ModelMap model, Todo todo) {
        String username = (String) model.get("name");
        todoservice.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }
}
