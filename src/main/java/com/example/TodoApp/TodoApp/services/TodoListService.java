package com.example.TodoApp.TodoApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.TodoApp.TodoApp.dto.TodoListPostRequestDTO;
import com.example.TodoApp.TodoApp.models.TodoList;
import com.example.TodoApp.TodoApp.repositories.TodoListRepository;

@Service
public class TodoListService {

    @Autowired
    private TodoListRepository todoListRepository;

    public ResponseEntity<List<TodoList>> getAllItems() {
        return new ResponseEntity<>(todoListRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<TodoList> createItem(TodoListPostRequestDTO request) {

        // check if item exist
        if (todoListRepository.findByItem(request.getItem()).isPresent()) {
            throw new IllegalStateException("Item already exists");
        }

        TodoList item = TodoList.builder()
                .item(request.getItem())
                .build();

        TodoList savedItem = todoListRepository.save(item);

        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);

    }

    public ResponseEntity<String> deleteItem(Long id) {
        // check if item exist by id first
        if (!todoListRepository.findById(id).isPresent()) {
            throw new IllegalStateException("Item does not exist");
        }

        try {
            todoListRepository.deleteById(id);
            return new ResponseEntity<>("success", HttpStatus.OK);

        } catch (Exception e) {
            throw new IllegalStateException(e.toString());
        }
    }

}
