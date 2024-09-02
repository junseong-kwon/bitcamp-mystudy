package com.example.todo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 이 클래스는 요청된 리소스를 찾지 못했을 때 발생시키는 예외를 정의함
@ResponseStatus(value = HttpStatus.NOT_FOUND) //HTTP 상태 코드를 404로 설정
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    // 생성자 : 예외 메시지를 받아 부모 클래스의 생성자에 전달
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
