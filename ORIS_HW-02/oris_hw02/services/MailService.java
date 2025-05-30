package itis.oris_hw02.services;

public interface MailService {
    void sendEmailForConfirm(String email, String code);
}
