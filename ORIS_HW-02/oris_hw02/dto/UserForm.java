package itis.oris_hw02.dto;
//пользователь заполняет и отправляет на сервер form

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //геттеры сеттеры
@NoArgsConstructor //конструктор без арг
@AllArgsConstructor //параметризированные конструкторы
@Builder//создание объекта
public class UserForm {
    private String login;
    private String email;
    private String password;

    private String Level;
}
