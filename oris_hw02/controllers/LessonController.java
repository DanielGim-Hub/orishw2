package itis.oris_hw02.controllers;


import itis.oris_hw02.dto.LessonDto;
import itis.oris_hw02.dto.LessonForm;
import itis.oris_hw02.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @PostMapping("/lesson")
    @ResponseBody
    public ResponseEntity<LessonDto> addLesson(@RequestBody LessonForm form) {
        return ResponseEntity.ok(lessonService.addLesson(form));
    }
    //localhost:8080/lessons/search?page=0&size=3
    @GetMapping("/lessons/search")//course
    @ResponseBody
    public ResponseEntity<List<LessonDto>> search(
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size,
            @RequestParam(value = "q", required = false) String query,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "direction", required = false) String direction
    ) {
        return ResponseEntity.ok(lessonService.search(page, size, query, sort, direction));
    }
}
