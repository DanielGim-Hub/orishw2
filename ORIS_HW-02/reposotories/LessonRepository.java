package itis.oris_hw02.reposotories;

import itis.oris_hw02.models.Lesson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    //раздлеление на страницы он вытаскивает некоторое количество данных и разделяет на страницы
    @Query("select lesson from Lesson lesson where(:q = 'empty' or UPPER(lesson.title) like upper(concat('%', :q, '%')))")
    Page<Lesson> search(@Param("q")String q, Pageable pageable);
    //Pageable разделяет на страницы и сам определяет размеры
    //page от pageble
}
