package itis.oris_hw02.services;

import itis.oris_hw02.dto.LessonDto;
import itis.oris_hw02.dto.LessonForm;

import java.util.List;

public interface LessonService {
    LessonDto addLesson(LessonForm lessonForm);
    List<LessonDto> search(Integer size, Integer page, String query, String sort, String direction);
}
