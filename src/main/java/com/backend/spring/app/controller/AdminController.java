package com.backend.spring.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.spring.app.entidad.Usuario;
import com.backend.spring.app.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
    private UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAll() {
		List<Usuario> usuarios = usuarioService.list();
        return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK);
	}
}
