package itis.oris_hw02.reposotories;

import itis.oris_hw02.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}