package com.habdiallo.react.webservices.restfulwebservices.Todo.controller;

import com.habdiallo.react.webservices.restfulwebservices.Todo.model.Todo;
import com.habdiallo.react.webservices.restfulwebservices.Todo.service.TodoHardcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
/*

Retrieve all todos for a user
GET /users/{user-name}/todos

Delete a Todo of a user
DELETE /users/{user-name}/todos/{todo-id}

Edit a Todo of a user
PUT /users/{user-name}/todos/{todo-id}

Create a new Todo of a user
Post /users/{user-name}/todos/

 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {

    @Autowired
    private TodoHardcodeService todoService;

    @GetMapping  (path = "/users/{username}/todos/{todoId}")
    public Todo getTodoByID(@PathVariable String username, @PathVariable Long todoId) {
        return todoService.findTodoByID(todoId);
    }

    @GetMapping(path = "/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoService.getAllTodos();
    }

    @PostMapping  (path = "/users/{username}/todos")
    public ResponseEntity<Void> addTodo(
            @PathVariable String username,
            @RequestBody Todo todo) {

        Todo createdTodo = todoService.save(todo);

        //Location
        //Get the current resource url
        ///users/{username}/todos/{todoId}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{todoId}").buildAndExpand(createdTodo.getId()).toUri();

        // Quand l'ajout reussi on build un lien du nouveau objet créer
        return ResponseEntity.created(uri).build();
    }

    @PutMapping  (path = "/users/{username}/todos/{todoId}")
    public ResponseEntity<Todo> updateTodoByID(
            @PathVariable String username,
            @PathVariable Long todoId,
            @RequestBody Todo todo) {

        Todo todoUpdated = todoService.save(todo);

        // La mise a jour retourne OK status et le nouveau objet modifier
        return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK);
    }

    @DeleteMapping(path = "/users/{username}/todos/{todoId}")
    public ResponseEntity<Void> deleteTodoByID(
        @PathVariable String username, @PathVariable long todoId) {
            Todo todo = todoService.deleteTodoByID(todoId);
            if (todo != null) {
                // Quand la suppression reussie on retourne no content
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
    }
}
