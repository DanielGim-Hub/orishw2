package itis.oris_hw02.services;

import itis.oris_hw02.dto.UserDto;
import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
}
