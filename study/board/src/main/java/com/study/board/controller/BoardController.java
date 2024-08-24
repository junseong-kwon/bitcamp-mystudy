package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

    @Autowired// BoardController에 BoardService객체를 생성해서 연결해준다.
    private BoardService boardService;

    @GetMapping("/board/write") //localhost:8090/board/write에
    public String boardWriteForm() { //boardwrite.html문서를 출력 하겠다는 뜻

        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board) { // 보드 객체를 받고

        boardService.write(board);

        return "";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {

        model.addAttribute("list", boardService.boardList()); // list라는 이름으로 보낼거야 보드 서비스의 보드 리스트를 리스트에 담아서 넘길거야

        return "boardlist";
    }
}
