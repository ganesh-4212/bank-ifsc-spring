package com.ganesh.bankifsc.dto;

import java.io.Serializable;

public class AuthResponseBodyDto implements Serializable {
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

	public AuthResponseBodyDto(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}
