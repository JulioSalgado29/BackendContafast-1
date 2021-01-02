package com.backend.spring.app.dto;

import com.sun.istack.NotNull;


public class UsuarioDto {
	
    private String ruc;
    private String username;
	@NotNull
    private String email;
	@NotNull
    private String password;
	private String estado;
	private String token;
    
    public UsuarioDto(){
    }
	public UsuarioDto(String ruc, String username, String email, String password, String estado, String token) {
		this.ruc = ruc;
		this.username = username;
		this.email = email;
		this.password = password;
		this.estado = estado;
		this.token = token;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
    
}