package com.study.board.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity  // 엔티티는 JPA에서 이 클래스가 데이터베이스와 연결되엇음을 알려주는 어노테이션
@Data
public class Board { // 데이터베이스의 테이블과 매핑된 JPA 엔티티임을 나타낸다. 기본적으로 데이터베이스의 Board 테이블에 매핑된다.

    @Id //프라이머리 키를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mariadb 설정 타입
    private Integer id;

    private String title;

    private String content;
}
