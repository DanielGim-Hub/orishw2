package itis.oris_hw02.dto;

import itis.oris_hw02.models.Lesson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonDto {
    private Long id;
    private String title;
    private String date;
    private String content;

    public static LessonDto of(Lesson lesson) {
        return LessonDto.builder()
                .id(lesson.getId())
                .title(lesson.getTitle())
                .date(lesson.getDate())
                .content(lesson.getContent())
                .build();

    }

    public static List<LessonDto> from(List<Lesson> lessons) {
        return lessons.stream()
                .map(LessonDto::of)
                .collect(Collectors.toList());
    }
}
