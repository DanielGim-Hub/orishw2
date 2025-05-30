package itis.oris_hw02.controllers;

import itis.oris_hw02.dto.CourseDto;
import itis.oris_hw02.dto.CourseForm;
import itis.oris_hw02.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users/{user-id}")
public class CourseController {
    private final CourseService courseService;

    // Просмотр созданных курсов (GET-запрос)
    @GetMapping("/created-courses")
    public String getCreatedCourses(
            @PathVariable("user-id") Long userId,
            Model model
    ) {
        model.addAttribute("courses", courseService.getCreatedCoursesByUser(userId));
        return "courses";
    }

    // Создание курса (POST-запрос)
    @PostMapping("/courses")
    @ResponseBody
    public CourseDto createCourse(
            @PathVariable("user-id") Long userId,
            @ModelAttribute CourseForm form
    ) {
        return courseService.createCourse(userId, form);
    }
}