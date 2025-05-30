package itis.oris_hw02.dto;

import itis.oris_hw02.models.Course;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private Long id;
    private String title;
    private String level;
    private String authorLogin;

    public static CourseDto from(Course course) {
        return CourseDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .level(course.getLevel())
                .authorLogin(course.getAuthor().getLogin())
                .build();
    }

    public static List<CourseDto> courseList(List<Course> courses) {
        return courses.stream()
                .map(CourseDto::from)
                .collect(Collectors.toList());
    }
}