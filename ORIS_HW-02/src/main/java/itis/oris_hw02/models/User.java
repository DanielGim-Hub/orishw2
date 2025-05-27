package itis.oris_hw02.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data //геттеры сеттеры
@NoArgsConstructor //конструктор без арг
@AllArgsConstructor //параметризированные конструкторы
@Builder//создание объекта
@Entity //обозначает как класса бд
@Table(name = "account") // название таблицы
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String email;
    private String password;
    private String level;

    @ManyToMany
    @JoinTable(
            name = "user_courses",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @Builder.Default
    private List<Course> enrolledCourses = new ArrayList<>();

    @OneToMany(mappedBy = "author")
    @Builder.Default
    private List<Course> createdCourses = new ArrayList<>();


    private Role role;
    private String confirmed;
}
