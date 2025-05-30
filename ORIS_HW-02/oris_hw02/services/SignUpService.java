package itis.oris_hw02.services;

import itis.oris_hw02.dto.UserForm;
import freemarker.template.TemplateException;

import java.io.IOException;

public interface SignUpService {
    public void addUser(UserForm userForm) throws TemplateException, IOException;
}
