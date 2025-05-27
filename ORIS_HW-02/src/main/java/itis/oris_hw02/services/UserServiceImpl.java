package itis.oris_hw02.services;

import itis.oris_hw02.dto.UserDto;
import itis.oris_hw02.reposotories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserDto> getAllUsers() {
        return UserDto.from(userRepository.findAll());
    }
}
