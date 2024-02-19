package com.example.springbootassignment.repositories;

import com.example.springbootassignment.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
