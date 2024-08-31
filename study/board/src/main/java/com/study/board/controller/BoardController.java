package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping
    public ResponseEntity<List<Board>> getAllBoards() {

        List<Board> boards = boardService.findAllBoards();

        return new ResponseEntity<>(boards, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable("id") Integer id) {  // 여기에서 "id"를 명시적으로 지정
        Board board = boardService.findBoardById(id);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Board> createBoard(@RequestBody Board board) {
        if (board.getContent() == null || board.getContent().trim().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Board newBoard = boardService.saveBoard(board);
        return new ResponseEntity<>(newBoard, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable("id") Integer id, @RequestBody Board board) {
        Board existingBoard = boardService.findBoardById(id);
        if (existingBoard == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // 기존 데이터의 타이틀과 내용을 유지하고, 완료 상태만 업데이트하는 로직
        existingBoard.setCompleted(board.getCompleted());
        Board updatedBoard = boardService.saveBoard(existingBoard);

        return new ResponseEntity<>(updatedBoard, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable("id") Integer id) {  // 여기에서 "id"를 명시적으로 지정
        boardService.deleteBoard(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
