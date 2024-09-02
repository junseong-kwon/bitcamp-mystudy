package com.example.todo.repository;


import com.example.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// TodoRepository는 데이터베이스 작업을 처리하는 인터페이스
// JpaRepository를 상속받아 CRUD 메서드를 자동으로 제공받음
// 이 인터페이스는 메서드 정의 없이도 기본적인 데이터 베이스 조작이 가능

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
