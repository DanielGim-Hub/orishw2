package itis.oris_hw02.services;

import itis.oris_hw02.dto.UserForm;
import itis.oris_hw02.models.Role;
import itis.oris_hw02.models.User;
import itis.oris_hw02.reposotories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@Service
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void addUser(UserForm form) {
        // 1) Создаём сущность
        User user = User.builder()
                .login(form.getLogin())
                .email(form.getEmail())
                .password(passwordEncoder.encode(form.getPassword()))
                .role(Role.ADMIN)
                .level("BEGINNER")
                .confirmed("UNCONFIRMED")
                .confirmCode(UUID.randomUUID().toString())
                .build();

        // 2) Сохраняем в БД
        userRepository.save(user);

        // 3) Отправляем письмо с кодом
        mailService.sendEmailForConfirm(user.getEmail(), user.getConfirmCode());
    }
}
