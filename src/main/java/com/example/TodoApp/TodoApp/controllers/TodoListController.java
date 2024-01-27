package com.example.TodoApp.TodoApp.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.TodoApp.TodoApp.dto.TodoListPostRequestDTO;
import com.example.TodoApp.TodoApp.models.TodoList;
import com.example.TodoApp.TodoApp.services.TodoListService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TodoListController {

    @Autowired
    private TodoListService todoListService;

    @RequestMapping("api/v1/todo_list/all")
    public ResponseEntity<List<TodoList>> requestMethodName() {
        return todoListService.getAllItems();
    }

    @PostMapping("api/v1/create")
    public ResponseEntity<TodoList> postMethodName(@RequestBody TodoListPostRequestDTO request) {
        return todoListService.createItem(request);
    }

    @DeleteMapping("api/v1/delete_item/{item_id}")
    public ResponseEntity<String> deleteItem(@PathVariable("item_id") Long id) {
        return todoListService.deleteItem(id);
    }

}
