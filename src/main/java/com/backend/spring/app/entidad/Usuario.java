package com.backend.spring.app.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

@Entity(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Column
    private String ruc;
	@NotNull
	@Column
    private String username;
	@NotNull
	@Column(unique=true)
    private String email;
	@NotNull
	@Column
    private String password;
	@NotNull
	@Column
    private String estado;
	@OneToOne
	@JoinColumn
	private Token token;
	
	
	public long getId() {
		return id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Usuario(String ruc, String username, String email, String password, String estado,
			Token token) {
		this.ruc = ruc;
		this.username = username;
		this.email = email;
		this.password = password;
		this.estado = estado;
		this.token = token;
	}
	
	public Usuario() {
	}
}