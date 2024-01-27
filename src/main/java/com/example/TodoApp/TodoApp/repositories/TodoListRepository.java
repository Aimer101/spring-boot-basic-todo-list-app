package com.example.TodoApp.TodoApp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TodoApp.TodoApp.models.TodoList;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {

    Optional<TodoList> findByItem(String item);

}
