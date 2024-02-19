package com.example.springbootassignment.services;

import com.example.springbootassignment.exceptions.EntityNotFoundException;
import com.example.springbootassignment.models.Todo;
import com.example.springbootassignment.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    public Todo getTodo(@PathVariable int id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            return todo.get();
        }
        throw new EntityNotFoundException("TODO with id " + id + " not found");
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(int id, Todo todoDetails) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todo.setTitle(todoDetails.getTitle());
            todo.setDescription(todoDetails.getDescription());
            todo.setStatus(todoDetails.getStatus());
            return todoRepository.save(todo);
        }
        throw new EntityNotFoundException("Todo with id " + id + " not found");
    }

    public void deleteTodo(int id) {
        todoRepository.deleteById(id);
    }
}
