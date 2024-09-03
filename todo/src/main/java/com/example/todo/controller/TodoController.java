package com.example.todo.controller;

import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 엔드포인트란 : 통신의 종착점
// REST API 컨트롤러
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/todos") // 이 컨트롤러는 "/api/todos" 경로와 매핑됨
public class TodoController {

    // Autowired는 TodoRepository 인스턴스를 자동으로 주입
    // new Repository를 생성하는 건데 그걸 외부에서 주입해주는 거임
    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo createdTodo = todoService.createTodo(todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Todo todo = todoService.getTodoById(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
