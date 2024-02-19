package com.example.springbootassignment.controllers;

import com.example.springbootassignment.beans.ResponseHandler;
import com.example.springbootassignment.models.Todo;
import com.example.springbootassignment.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public ResponseEntity<?> getAllTodos() {
        return ResponseHandler.createResponse("Found Todos", HttpStatus.OK, todoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTodo(@PathVariable int id) {
        Todo todo = todoService.getTodo(id);
        return ResponseHandler.createResponse("Found Todo", HttpStatus.OK, todo);
    }

    @PostMapping("/")
    public ResponseEntity<?> createTodo(@RequestBody Todo todo) {
        Object createdTodo = todoService.createTodo(todo);
        return ResponseHandler.createResponse("Todo Created", HttpStatus.CREATED, createdTodo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable int id, @RequestBody Todo todo) {
        Todo updatedTodo = todoService.updateTodo(id, todo);
        return ResponseHandler.createResponse("Todo Updated", HttpStatus.OK, updatedTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
        return ResponseHandler.deleteResponse("Todo Deleted", HttpStatus.OK);
    }
}
