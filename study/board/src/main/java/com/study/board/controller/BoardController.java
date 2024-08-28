package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {

    @Autowired// BoardController에 BoardService객체를 생성해서 연결해준다.
    private BoardService boardService;

    @GetMapping("/board/write") //localhost:8090/board/write에
    public String boardWriteForm() { //boardwrite.html문서를 출력 하겠다는 뜻

        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board, Model model) { // 보드 객체를 받고

        boardService.write(board);

            model.addAttribute("message", "글 작성이 완료되었습니다."); //메시지를 받은거 출력
        model.addAttribute("searchUrl", "/board/list"); // 보내줄 위치 지정

        return "message";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {

        model.addAttribute("list", boardService.boardList()); // list라는 이름으로 보낼거야 보드 서비스의 보드 리스트를 리스트에 담아서 넘길거야

        return "boardlist";
    }

    @GetMapping("/board/view") // localhost:8090/board/view?id=1
    public String boardView(Model model, @RequestParam("id") Integer id) { //매개변수에서 다시 받아올떄는 Model을 적어줘야 한다.  1이 들어가서

        model.addAttribute("board", boardService.boardView(id)); //게시글을 불러온다

        return "boardview";
    }

    @GetMapping("/board/delete")
        public String boardDelete(@RequestParam("id") Integer id, Model model) {

        boardService.boardDelete(id);
            if (true) {
             model.addAttribute("message", "글 삭제가 완료되었습니다.");
    //메시지를 받은거 출력
            } else {
            return "boardview";
            }
        model.addAttribute("searchUrl", "/board/list");

        return "message";
    }

    @GetMapping("/board/modify/{id}") //뒤에 있는 중괄호의 아이디가
    public String boardModify(@PathVariable("id")  Integer id, Model model) { // PathVariable에 인식되서 Integer 형태의 id값으로 들어옴

        model.addAttribute("board", boardService.boardView(id));

        return "boardmodify";
    }

    // url의 파라미터를 넘길떄 방법은 2가지
    //첫번째는 queryString을 쓰는 방법
    //PathVariable을 통해서 값을 받아오는 방법이 있다.

   @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board, Model model) {


       boardService.write(board);

        Board boardTemp = boardService.boardView(id);

        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());
       boardService.write(boardTemp);


       model.addAttribute("message", "글 수정이 완료되었습니다."); //메시지를 받은거 출력
       model.addAttribute("searchUrl", "/board/list");




        return "message";
   }
}
