package com.ganesh.bankifsc.dto;

import java.io.Serializable;

public class AuthRequestBodyDto implements Serializable {

	private static final long serialVersionUID = 6244160308816495495L;
	private String username;
	private String password;

	public AuthRequestBodyDto() {
	}

	public AuthRequestBodyDto(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
