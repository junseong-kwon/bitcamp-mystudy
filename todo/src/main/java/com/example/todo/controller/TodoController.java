package com.example.todo.controller;


import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//엔드포인트란 : 통신의 종착점
//RESTAPI컨트롤러
@RestController
@RequestMapping("/api/todos")//이 컨트롤러는 "/api/todos"경로와 매핑됨
public class TodoController {


    //Autowired는 TodoRepository 인스턴스를 자동으로 주입
    // new Repository를 생성하는 건데 그걸 외부에서 주입해주는 거임
    @Autowired
    private TodoRepository todoRepository;

    //이 메서드는 레포지토리에 저장한 모든 데이터베이스의 목록을 전부 가져오는 역할
    @GetMapping //데이터를 조회할 떄 사용하고 데이터의 영향을 미치지 않음
    public List<Todo> getAllTodos() {
        // 리포지토리 데이터 베이스에서 모든 할 일 목록을 가져와서 반환한다.
        return todoRepository.findAll();
    }

    //@PostMapping은 HTTP POST 요청을 처리
    //클라이언트가 새로운 할 일을 생성할 때 호출
    @PostMapping //새로운 데 http에서 데이텁
    public Todo createTodo(@RequestBody Todo todo) {
        // 클라이언트로부터 받은 데이터를 데이터베이스에 저장, 저장된 데이터를 반환
        return todoRepository.save(todo);
    }

    // 이 메서드는 클라이언트가 할 일을 수정할때  호출
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable Long id, // 클라이언트가 URL경로에서 전달한 {Id}값을 메서드의 id변수로 사용
            @RequestBody Todo todoDetails) { // 클라이언트로부터 수정할 데이터가 JSON 형식으로 전달

        // 데이터베이스에서 해당 ID를 가진 할 일을 찾음 없으면 예외를 처리해줌
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found"));

        // 기존 할 일 데이터를 클라이언트가 보낸 데이터로 업데이트
        todo.setTitle(todoDetails.getTitle());
        todo.setDescription(todoDetails.getDescription());
        todo.setCompleted(todoDetails.isCompleted());

        // 업데이트를 했으면 데이터베이스에 저장하고, 업데이트된 데이터를 반환
        final Todo updatedTodo = todoRepository.save(todo);
        return ResponseEntity.ok(updatedTodo);
    }

    //클라이언트가 데이터를 삭제할 때 호출
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteTodo(@PathVariable Long id) {
        Todo todo = todoRepository.findById(id) // 해당 id를 찾음
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found"));


        todoRepository.delete(todo); // 데이터를 삭제
        Map<String, Boolean> response = new HashMap<>(); // 삭제된 것을 클라이언트에 알리기 위해 맵을 반환
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
