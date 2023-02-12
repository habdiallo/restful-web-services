package com.habdiallo.react.webservices.restfulwebservices.Todo.service;

import com.habdiallo.react.webservices.restfulwebservices.Todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodeService {
    private static List<Todo> todos = new ArrayList<>();

    private static int idCounter = 0;
    static {
        todos.add(new Todo(++idCounter, "version", "Learn react", new Date(), false ));
        todos.add(new Todo(++idCounter, "version", "Learn node", new Date(), false ));
        todos.add(new Todo(++idCounter, "version", "Learn springboot", new Date(), false ));
    }

    public static int getId() {
        return idCounter;
    }

    public List<Todo> getAllTodos() {
        return todos;
    }

    public Todo findTodoByID(long todoId) {
        for (Todo todo : todos){
            if (todo.getId() == todoId){
                return todo;
            }
        } return null;
    }

    public Todo deleteTodoByID(long todoId) {
        Todo todo = findTodoByID(todoId);
        if (todo == null) return null;
        if (todos.remove(todo)) {
            return todo;
        }
        return null;
    }

    public Todo save(Todo todo) {
        if (todo.getId() == -1 || todo.getId() == 0) {
            todo.setId(++idCounter);
            todos.add(todo);
        } else {
            deleteTodoByID(todo.getId());
            todos.add(todo);
        }
        return todo;
    }
}
