package itis.oris_hw02.services;

import itis.oris_hw02.dto.UserForm;
import itis.oris_hw02.models.Role;
import itis.oris_hw02.models.User;
import itis.oris_hw02.reposotories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component//?
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void addUser(UserForm userForm) {
        User user = User.builder()
                .login(userForm.getLogin())
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .confirmed("CONFIRMED")
                .role(Role.ADMIN)
                .build();
        userRepository.save(user);
    }
}