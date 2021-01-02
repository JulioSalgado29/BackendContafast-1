package com.backend.spring.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.spring.app.entidad.Token;


@Repository
public interface TokenDao extends JpaRepository<Token, Long>{
}