package com.example.todo.service;


import com.example.todo.controller.ResourceNotFoundException;
import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {//이 메서드는 레포지토리에 저장한 모든 데이터베이스의 목록을 전부 가져오는 역할
        return todoRepository.findAll(); //데이터를 조회할 떄 사용하고 데이터의 영향을 미치지 않음
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found"));
    }

    public void deleteTodoById(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Todo not found with id " + id);
        }
         todoRepository.deleteById(id);
    }
}
