package itis.oris_hw02.services;

import itis.oris_hw02.dto.UserDto;
import itis.oris_hw02.models.User;
import itis.oris_hw02.reposotories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return UserDto.from(userRepository.findAll());
    }

    @Override
    public boolean confirmUser(String code) {
        Optional<User> userOpt = userRepository.findByConfirmCode(code);
        if (userOpt.isEmpty()) {
            return false;
        }
        User user = userOpt.get();
        if ("CONFIRMED".equals(user.getConfirmed())) {
            return false; // уже подтверждён
        }
        user.setConfirmed("CONFIRMED");
        user.setConfirmCode(null);
        userRepository.save(user);
        return true;
    }
}
