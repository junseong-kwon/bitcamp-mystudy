package com.study.board.service;


import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository; //Autowired하면 서비스와 레포지토리와 연결해준다.


    // 게시글 리스트 처리
    public List<Board> findAllBoards() {

        return boardRepository.findAll();
    }

    public Board findBoardById(Integer id) {
        Optional<Board> optionalBoard = boardRepository.findById(id);
        return optionalBoard.orElse(null);
    }

    //글 작성 처리
    public Board saveBoard(Board board) {

        return boardRepository.save(board); //save는 Board엔티티를 이 안에 저장한다는 의미
    }

    public void deleteBoard(Integer id) {

        boardRepository.deleteById(id);
    }
}
