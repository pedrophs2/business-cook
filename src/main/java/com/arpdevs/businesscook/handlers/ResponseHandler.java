package com.arpdevs.businesscook.handlers;

import org.springframework.http.HttpStatus;

public class ResponseHandler<E> {
	private HttpStatus code;
	private String message;
	private E response;

	public ResponseHandler() {
	}

	public ResponseHandler(HttpStatus code, String message, E response) {
		super();
		this.code = code;
		this.message = message;
		this.response = response;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public E getResponse() {
		return response;
	}

	public void setResponse(E response) {
		this.response = response;
	}

}
