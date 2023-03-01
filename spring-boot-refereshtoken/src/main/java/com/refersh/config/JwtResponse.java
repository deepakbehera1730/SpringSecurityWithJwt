package com.refersh.config;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String jwttoken;
	private final String refreshtoken;

	public String getRefreshtoken() {
		return refreshtoken;
	}

	public JwtResponse(String jwttoken, String refreshtoken) {
		super();
		this.jwttoken = jwttoken;
		this.refreshtoken = refreshtoken;
	}

	public String getJwttoken() {
		return jwttoken;
	}
}
