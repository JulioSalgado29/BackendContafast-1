package com.backend.spring.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.backend.spring.app.dao.UsuarioDao;
import com.backend.spring.app.entidad.Usuario;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	UsuarioDao usuariodao;
	@Autowired
    private JavaMailSender javaMailSender;
	
	public List<Usuario> list(){
		return usuariodao.findAll();
	}
	
	public void save(Usuario usuario) {
		usuariodao.save(usuario);
	}
	
	public Optional<Usuario> getByEmail(String email){
		return usuariodao.findByEmail(email);
	}
	public Optional<Usuario> getByPassword(String password){
		return usuariodao.findByPassword(password);
	}

    public void sendMail(String from, String to, String subject, String body) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(from);
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(body);
        javaMailSender.send(mail);
    }
}