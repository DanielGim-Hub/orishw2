package itis.oris_hw02.dto;

import itis.oris_hw02.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;

    private String login;
    private String email;
    private String password;

    //dto сам собирается при самом вызове
    //для одного пользователя
    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();

    }
    //для возрващения нескольких пользователей для того чтобы передать на фронт
    public static List<UserDto> from(List<User> user) {
        return user.stream().
                map(UserDto::from).
                collect(Collectors.toList());
    }
}
