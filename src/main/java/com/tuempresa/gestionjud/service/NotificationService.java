package com.tuempresa.gestionjud.service;

import com.tuempresa.gestionjud.domain.Comentario;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final JavaMailSender mailSender;

    public NotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void notifyComentario(Comentario comentario) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(comentario.getUsuario().getEmail());
        msg.setSubject("Nuevo comentario");
        msg.setText(comentario.getTexto());
        mailSender.send(msg);
    }
}
