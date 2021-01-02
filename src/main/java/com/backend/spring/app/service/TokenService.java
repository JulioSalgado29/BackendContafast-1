package com.backend.spring.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.spring.app.dao.TokenDao;
import com.backend.spring.app.entidad.Token;

@Service
@Transactional
public class TokenService {
	
	@Autowired
	TokenDao tokenDao;
	
	public void save(Token token) {
		tokenDao.save(token);
	}
	public Optional<Token> findById(Long id){
		return tokenDao.findById(id);
	}
}
