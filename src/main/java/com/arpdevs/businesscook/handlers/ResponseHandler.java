package com.arpdevs.businesscook.handlers;

import org.springframework.http.HttpStatus;

public class ResponseHandler<E> {

	private HttpStatus status;
	private String message;
	private E response;

	public ResponseHandler() {
	}

	public ResponseHandler(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ResponseHandler(HttpStatus status, String message, E response) {
		super();
		this.status = status;
		this.message = message;
		this.response = response;
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

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
