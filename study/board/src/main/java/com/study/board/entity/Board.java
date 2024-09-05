package com.study.board.entity;


import javax.persistence.*;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity  // 엔티티는 JPA에서 이 클래스가 데이터베이스와 연결되엇음을 알려주는 어노테이션
public class Board { // 데이터베이스의 테이블과 매핑된 JPA 엔티티임을 나타낸다. 기본적으로 데이터베이스의 Board 테이블에 매핑된다.

    @Id //프라이머리 키를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mariadb 설정 타입
    private Integer id;
    private String title;
    private String content;
    private Boolean completed = false;

    public Board() {}

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
        this.completed = false;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
