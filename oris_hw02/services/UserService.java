package itis.oris_hw02.services;

import itis.oris_hw02.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    /**
     * Подтверждает пользователя по коду:
     * - если код найден и пользователь не подтверждён, меняет confirmed → "CONFIRMED" и обнуляет confirmCode;
     * - возвращает true, если подтверждение прошло успешно.
     */
    boolean confirmUser(String code);
}
