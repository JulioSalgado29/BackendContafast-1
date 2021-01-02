package com.backend.spring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.spring.app.service.TokenService;
import com.backend.spring.app.service.UsuarioService;
import com.backend.spring.app.dto.UsuarioDto;
import com.backend.spring.app.entidad.Token;
import com.backend.spring.app.entidad.Usuario;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
    private UsuarioService usuarioService;
	
	@Autowired
    private TokenService tokenService;
	
	@PostMapping("/verificarusuario")
	public ResponseEntity<?> verificatedUsuario(@Validated @RequestBody UsuarioDto usuarioDto) {
		if(!usuarioService.getByEmail(usuarioDto.getEmail()).isPresent())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El email es incorrecto");
		Usuario usuario = usuarioService.getByEmail(usuarioDto.getEmail()).get();
		if(!usuario.getPassword().equals(usuarioDto.getPassword()))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La contraseña es incorrecta");
		Token token = tokenService.findById(usuario.getId()).get();
		if(usuario.getEstado().equalsIgnoreCase("0"))
		{
			usuarioService.sendMail("contafastmail@gmail.com",usuario.getEmail(),"Verificación de correo Contafast","El token de verificacion es: "+token.getCodigo());
		}
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}
	@PutMapping("/actualizarestado")
	public ResponseEntity<?> verificatedEstado(@Validated @RequestBody UsuarioDto usuarioDto) {
		Usuario usuario = usuarioService.getByEmail(usuarioDto.getEmail()).get();
		if(!usuarioDto.getToken().equals(tokenService.findById(usuario.getId()).get().getCodigo()))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR, vuelva a colocar el token");
		usuario.setEstado("1");
		usuarioService.save(usuario);
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}
}