package itis.oris_hw02.services;

import itis.oris_hw02.dto.LessonDto;
import itis.oris_hw02.dto.LessonForm;
import itis.oris_hw02.models.Lesson;
import itis.oris_hw02.reposotories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;


    @Override
    public LessonDto addLesson(LessonForm lessonForm) {
        Lesson lesson = Lesson.builder()
                .title(lessonForm.getTitle())
                .date(lessonForm.getDate())
                .content(lessonForm.getContent())
                .build();
        lessonRepository.save(lesson);
        return LessonDto.of(lesson);
    }

    @Override
    public List<LessonDto> search(Integer size, Integer page, String query, String sortParameter, String directionParametr) {
        Sort.Direction direction = Sort.Direction.ASC; //не рамодом сортировка по возраст айди
        Sort sort = Sort.by(direction, "id");

        if (directionParametr != null) {
            direction = Sort.Direction.fromString(directionParametr);
        }
        if (sortParameter != null) {
            sort = Sort.by(direction, sortParameter);
        }

        if (query == null) {
            query = "empty";
        }

        if (size == null) {
            size = 3;
        }

        PageRequest pageRequest = PageRequest.of(page, size, sort);
        System.out.println(pageRequest);
        Page<Lesson> papersPage = lessonRepository.search(query, pageRequest);
        return LessonDto.from(papersPage.getContent());

    }
}
