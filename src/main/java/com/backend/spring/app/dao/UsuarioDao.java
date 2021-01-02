package com.backend.spring.app.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.spring.app.entidad.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByEmail(String email);
	Optional<Usuario> findByPassword(String password);
}