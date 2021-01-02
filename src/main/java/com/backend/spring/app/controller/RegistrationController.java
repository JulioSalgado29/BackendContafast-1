package com.backend.spring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.backend.spring.app.dto.UsuarioDto;
import com.backend.spring.app.service.UsuarioService;
import com.backend.spring.app.entidad.Usuario;
import com.backend.spring.app.service.TokenService;
import com.backend.spring.app.entidad.Token;
import java.security.SecureRandom;
import java.math.BigInteger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
    private UsuarioService usuarioService;
	@Autowired
    private TokenService tokenService;
	
	@PostMapping("/crearusuario")
    public ResponseEntity<?> createUsuario(@RequestBody UsuarioDto usuarioDto) {
		if(usuarioDto.getRuc()==null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El RUC es obligatorio");
		if(usuarioDto.getUsername()==null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El username es obligatorio");
		if(usuarioDto.getEmail()==null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El email es obligatorio");
		if(usuarioDto.getPassword()==null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El password es obligatorio");
		if(usuarioService.getByEmail(usuarioDto.getEmail()).isPresent())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El email ya se encuentra registrado");
		SecureRandom random = new SecureRandom();
		Token token = new Token(new BigInteger(130, random).toString(32));
		tokenService.save(token);
		Usuario usuario = new Usuario(usuarioDto.getRuc(),usuarioDto.getUsername(),usuarioDto.getEmail(),usuarioDto.getPassword(),"0",token);
		usuarioService.save(usuario);
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }
}
