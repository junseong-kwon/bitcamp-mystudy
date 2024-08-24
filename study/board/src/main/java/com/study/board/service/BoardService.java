package com.study.board.service;


import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository; //Autowired하면 서비스와 레포지토리와 연결해준다.

    public void write(Board board) {

        boardRepository.save(board); //save는 Board엔티티를 이 안에 저장한다는 의미
    }

    public List<Board> boardList() {

        return boardRepository.findAll();
    }
}
