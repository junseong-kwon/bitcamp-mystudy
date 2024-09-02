package com.example.student.student_room;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentRoomController {

    @GetMapping("/student-room")
    public String showStudentRoomPop() {
        return "studentRoomPop";
    }
}
