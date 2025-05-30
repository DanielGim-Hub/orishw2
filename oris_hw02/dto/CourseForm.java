package itis.oris_hw02.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //геттеры сеттеры
@NoArgsConstructor //конструктор без арг
@AllArgsConstructor //параметризированные конструкторы
@Builder//создание объекта
public class CourseForm {
    private String title;
    private String level;
}
