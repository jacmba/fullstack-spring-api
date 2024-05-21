package net.jazbelt.fullstackspringapi.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable("username") String username) {
        return todoService.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo retrieveTodo(
            @PathVariable("username") String username,
            @PathVariable("id") Integer id
    ) {
        return todoService.findById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deteleTodo(
            @PathVariable("username") String username,
            @PathVariable("id") Integer id
    ) {
        todoService.deleteById(id);
    }
}
