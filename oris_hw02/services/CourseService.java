package itis.oris_hw02.services;

import itis.oris_hw02.dto.CourseDto;
import itis.oris_hw02.dto.CourseForm;

import java.util.List;

public interface CourseService {
    //список пользователй
    List<CourseDto> getCreatedCoursesByUser(Long id);

    //список созданных курсов
    CourseDto createCourse(Long userId, CourseForm courseForm);
}

