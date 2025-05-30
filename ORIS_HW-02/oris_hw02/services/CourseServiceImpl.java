package itis.oris_hw02.services;

import itis.oris_hw02.dto.CourseDto;
import itis.oris_hw02.dto.CourseForm;
import itis.oris_hw02.models.Course;
import itis.oris_hw02.models.User;
import itis.oris_hw02.reposotories.CourseRepository;
import itis.oris_hw02.reposotories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    @Override
    public List<CourseDto> getCreatedCoursesByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow();
        return CourseDto.courseList(user.getCreatedCourses());
    }

    @Override
    public CourseDto createCourse(Long userId, CourseForm form) {
        User author = userRepository.findById(userId)
                .orElseThrow();
        Course course = Course.builder()
                .title(form.getTitle())
                .level(form.getLevel())
                .author(author)
                .build();

        courseRepository.save(course);
        return CourseDto.from(course);
    }
}