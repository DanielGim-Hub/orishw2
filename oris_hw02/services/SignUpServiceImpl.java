package itis.oris_hw02.services;

import freemarker.template.TemplateException;
import itis.oris_hw02.dto.UserForm;
import itis.oris_hw02.models.Role;
import itis.oris_hw02.models.User;
import itis.oris_hw02.reposotories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;


@Component//?
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MailService mailService;


    @Override
    public void addUser(UserForm userForm) throws TemplateException, IOException {
        User user = User.builder()
                .login(userForm.getLogin())
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .confirmed("CONFIRMED")
                .role(Role.ADMIN)
                .confirmCode(UUID.randomUUID().toString())
                .build();
        userRepository.save(user);

        mailService.sendEmailForConfirm(user.getEmail(), user.getConfirmCode());
    }
}