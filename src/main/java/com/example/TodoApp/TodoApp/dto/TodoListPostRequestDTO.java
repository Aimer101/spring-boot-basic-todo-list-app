package com.example.TodoApp.TodoApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoListPostRequestDTO {
    private String item;
}
