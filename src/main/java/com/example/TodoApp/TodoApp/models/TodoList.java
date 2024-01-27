package com.example.TodoApp.TodoApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "todo_list")
@Entity(name = "TodoList")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoList {
    @Id
    @SequenceGenerator(name = "todo_list_sequence", sequenceName = "todo_list_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_list_sequence")
    Long id;

    String item;

}
